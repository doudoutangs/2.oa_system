package com.bank.project.oa.controller;

import com.bank.framework.aspectj.lang.annotation.Log;
import com.bank.framework.aspectj.lang.enums.BusinessType;
import com.bank.framework.web.controller.BaseController;
import com.bank.framework.web.domain.AjaxResult;
import com.bank.framework.web.page.TableDataInfo;
import com.bank.project.oa.domain.Contract;
import com.bank.project.oa.service.IContractService;
import com.bank.project.system.user.domain.User;
import com.bank.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 合同信息
 *
 * @author bank
 */
@Controller
@RequestMapping("oa/contract")
public class ContractController extends BaseController {
    private String prefix = "oa/contract";

    @Autowired
    private IContractService contractService;
    @Autowired
    private IUserService userService;

    @RequiresPermissions("oa:contract:view")
    @GetMapping()
    public String asset(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/index";
    }

    @RequiresPermissions("oa:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Contract record) {
        startPage();
        List<Contract> list = contractService.selectList(record);
        return getDataTable(list);
    }


    /**
     * 新增合同
     */
    @GetMapping("/add")
    public String add(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/add";
    }
    /**
     * 新增保存合同
     */
    @RequiresPermissions("oa:contract:add")
    @Log(title = "合同管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Contract record) {
        int insert = contractService.insert(record);
        return toAjax(insert);
    }
    /**
     * 修改合同
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("record", contractService.getById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存合同
     */
    @RequiresPermissions("oa:contract:edit")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Contract record) {
        return toAjax(contractService.update(record));
    }


    @RequiresPermissions("oa:contract:remove")
    @Log(title = "合同管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(contractService.deleteByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}