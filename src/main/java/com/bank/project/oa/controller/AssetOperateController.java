package com.bank.project.oa.controller;

import com.bank.common.utils.StringUtils;
import com.bank.common.utils.security.ShiroUtils;
import com.bank.framework.aspectj.lang.annotation.Log;
import com.bank.framework.aspectj.lang.enums.BusinessType;
import com.bank.framework.web.controller.BaseController;
import com.bank.framework.web.domain.AjaxResult;
import com.bank.framework.web.page.TableDataInfo;
import com.bank.project.oa.constant.AssetConstant;
import com.bank.project.oa.domain.Asset;
import com.bank.project.oa.domain.AssetOperate;
import com.bank.project.oa.service.IAssetOperateService;
import com.bank.project.oa.service.IAssetService;
import com.bank.project.system.dict.domain.DictData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 个人信息 业务处理
 *
 * @author bank
 */
@Controller
@RequestMapping("/oa/asset/operate")
public class AssetOperateController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(AssetOperateController.class);

    private String prefix = "oa/asset/operate";

    @Autowired
    private IAssetOperateService assetOperateService;
    @Autowired
    private IAssetService assetService;

    /**
     * 查询资产操作记录
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("assetId", id);
        return prefix + "/record";
    }

    /**
     * 跳转到资产归还页面
     */
    @GetMapping("/revert/{id}")
    public String revert(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("asset", assetService.getById(id));
        return prefix + "/revert";
    }

    /**
     * 跳转到资产退回页面
     */
    @GetMapping("/back/{id}")
    public String back(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("asset", assetService.getById(id));
        return prefix + "/back";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@Validated AssetOperate AssetOperate) {
        startPage();
        List<AssetOperate> list = assetOperateService.selectList(AssetOperate);
        return getDataTable(list);
    }

    /**
     * 新增资产操作记录
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("asset", assetService.getById(id));
        return prefix + "/lend";
    }


    /**
     * 新增保存资产操作记录
     */
    @RequiresPermissions("oa:asset:operate:add")
    @Log(title = "新增资产操作记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated AssetOperate operate) {
        //1.更新资产数量和状态
        AjaxResult x = updateAsset(operate);
        if (!x.get(AjaxResult.CODE_TAG).equals(AjaxResult.Type.SUCCESS.value())) {
            return x;
        }
        operate.setOperateUserId(String.valueOf(ShiroUtils.getUserName()));
        return toAjax(assetOperateService.insert(operate));
    }

    /**
     * 更新资产状态
     *
     * @param operate
     * @return
     */
    private AjaxResult updateAsset(AssetOperate operate) {
        String operateNum = operate.getOperateNum();
        String operateType = operate.getOperateType();

        Long assetId = operate.getAssetId();
        Asset assetInfo = assetService.getById(assetId);
        String num = assetInfo.getNum();
        String status = assetInfo.getStatus();
        String assetType = assetInfo.getAssetType();
        if (num.equals("0")) {
            return error("资产数量为空，不可操作");
        }
        if (Integer.valueOf(operateNum) > Integer.valueOf(num)) {
            return error("操作数量大于库存数量，不可操作");
        }
        if (AssetConstant.STATUS_LEND.equals(status) && AssetConstant.OPERATE_LEND.equals(operateType)) {
            return error("资产已借出，不可操作");
        }
        String newNum = num;
        String afterStatus = assetInfo.getStatus();
        Integer rate = 0;
        if (!AssetConstant.TYPE_CONSUMABLE.equals(assetType)) {
            //非消耗品则更改状态
            if (AssetConstant.OPERATE_LEND.equals(operateType)) {
                afterStatus = AssetConstant.STATUS_LEND;
            } else if (AssetConstant.OPERATE_RETURN.equals(operateType)) {
                afterStatus = AssetConstant.STATUS_NORMAL;
            }
            //修改折损率
            String abradeRateNew = StringUtils.isBlank(operate.getAbradeRate()) ? "0" : operate.getAbradeRate();
            String abradeRate = StringUtils.isBlank(assetInfo.getAbradeRate()) ? "0" : assetInfo.getAbradeRate();
            rate = Integer.valueOf(abradeRateNew) + Integer.valueOf(abradeRate);
            if (rate >= 100) {
                //折损率达到100状态修改为报废
                afterStatus = AssetConstant.STATUS_SCRAP;
            }
        } else {
            //消耗品更改数量
            if (AssetConstant.STATUS_LEND.equals(operateType)) {
                //领用
                newNum = String.valueOf(Integer.valueOf(num) - Integer.valueOf(operateNum));
            } else {
                //退回
                newNum = String.valueOf(Integer.valueOf(num) + Integer.valueOf(operateNum));
            }
        }
        Asset asset = new Asset();
        asset.setNum(newNum);
        asset.setId(assetId);
        asset.setRevertTime(operate.getRevertTime());
        asset.setStatus(afterStatus);
        asset.setAbradeRate(rate.toString());
        int update = assetService.update(asset);
        if (update == 1) {
            return success();
        }
        return error();
    }

}
