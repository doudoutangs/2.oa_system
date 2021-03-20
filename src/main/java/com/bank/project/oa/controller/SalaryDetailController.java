package com.bank.project.oa.controller;

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
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 薪资详情信息
 *
 * @author bank
 */
@Controller
@RequestMapping("salary/detail")
public class SalaryDetailController extends BaseController {
    private String prefix = "salary/detail";

    @Autowired
    private IAssetService assetService;
    @Autowired
    private IAssetOperateService assetOperateService;
    @RequiresPermissions("salary:detail:view")
    @GetMapping()
    public String asset() {
        return prefix + "/asset";
    }

    @RequiresPermissions("salary:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Asset asset) {
        startPage();
        List<Asset> list = assetService.selectList(asset);
        return getDataTable(list);
    }


    /**
     * 新增薪资详情
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }


    /**
     * 新增保存薪资详情
     */
    @RequiresPermissions("salary:detail:add")
    @Log(title = "薪资详情管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Asset asset) {
        //1.添加薪资详情
        String addUserId = String.valueOf(ShiroUtils.getUserName());
        asset.setAddUserId(addUserId);
        int insert = assetService.insert(asset);
        //2.增加入库详情
        AssetOperate operate = new AssetOperate();
        operate.setOperateNum(asset.getNum());
        operate.setAssetId(asset.getId());
        operate.setOperateType(AssetConstant.OPERATE_ADD);
        operate.setOperateUserId(addUserId);
        operate.setOperateDate(asset.getAddTime());
        assetOperateService.insert(operate);
        return toAjax(insert);
    }

    /**
     * 修改薪资详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("asset", assetService.getById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存薪资详情
     */
    @RequiresPermissions("salary:detail:edit")
    @Log(title = "薪资详情管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Asset asset) {
        return toAjax(assetService.update(asset));
    }


    @RequiresPermissions("salary:detail:remove")
    @Log(title = "薪资详情管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(assetService.deleteByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
    /**
     * 薪资详情统计
     */
    @GetMapping("/stat")
    public String stat(ModelMap mmap) {
        mmap.put("stat", assetService.stat());
        return "/main";
    }

}