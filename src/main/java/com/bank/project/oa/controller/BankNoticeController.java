package com.bank.project.oa.controller;//package com.bank.project.oa.controller;

import com.bank.common.utils.security.ShiroUtils;
import com.bank.framework.aspectj.lang.annotation.Log;
import com.bank.framework.aspectj.lang.enums.BusinessType;
import com.bank.framework.web.controller.BaseController;
import com.bank.framework.web.domain.AjaxResult;
import com.bank.framework.web.page.TableDataInfo;
import com.bank.project.oa.domain.BankNotice;
import com.bank.project.oa.service.IBankNoticeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bank
 */
@Controller
@RequestMapping("/oa/notice")
public class BankNoticeController extends BaseController {

    private String prefix = "oa/notice";

    @Autowired
    private IBankNoticeService bankNoticeService;

    @RequiresPermissions("oa:notice:view")
    @GetMapping()
    public String notice() {
        return prefix + "/notice";
    }

    @RequiresPermissions("oa:notice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BankNotice notice) {
        startPage();
        //
        List<BankNotice> list = bankNoticeService.selectList(notice);
        return getDataTable(list);
    }

    @RequiresPermissions("oa:notice:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("notice", bankNoticeService.getById(id));
        return prefix + "/detail";
    }

    /**
     * 新增公文
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }


    /**
     * 新增保存公文
     */
    @RequiresPermissions("oa:notice:add")
    @Log(title = "公文管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated BankNotice notice) {

        notice.setPublishUserId(String.valueOf(ShiroUtils.getUserName()));
        return toAjax(bankNoticeService.insert(notice));
    }
    /**
     * 审批
     */
    @RequiresPermissions("oa:notice:approval")
    @GetMapping("/approval/{id}")
    public String approval(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("notice", bankNoticeService.getById(id));
        return prefix + "/approval";
    }
    /**
     * 修改公文
     */

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("notice", bankNoticeService.getById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存公文
     */
    @RequiresPermissions("oa:notice:edit")
    @Log(title = "公文管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated BankNotice notice) {
        return toAjax(bankNoticeService.update(notice));
    }


    @RequiresPermissions("oa:notice:remove")
    @Log(title = "公文管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(bankNoticeService.deleteByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

}