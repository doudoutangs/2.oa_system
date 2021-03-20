package com.bank.project.oa.controller;

import com.bank.framework.aspectj.lang.annotation.Log;
import com.bank.framework.aspectj.lang.enums.BusinessType;
import com.bank.framework.web.controller.BaseController;
import com.bank.framework.web.domain.AjaxResult;
import com.bank.framework.web.page.TableDataInfo;
import com.bank.project.oa.domain.UserPlan;
import com.bank.project.oa.service.IUserPlanService;
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
 * 计划信息
 *
 * @author bank
 */
@Controller
@RequestMapping("oa/plan")
public class UserPlanController extends BaseController {
    private String prefix = "oa/plan";

    @Autowired
    private IUserPlanService userPlanService;
    @Autowired
    private IUserService userService;

    @RequiresPermissions("oa:plan:view")
    @GetMapping()
    public String asset(ModelMap mmap, User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/index";
    }

    @RequiresPermissions("oa:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserPlan record) {
        startPage();
        List<UserPlan> list = userPlanService.selectList(record);
        return getDataTable(list);
    }


    /**
     * 新增计划
     */
    @GetMapping("/add")
    public String add(ModelMap mmap, User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/add";
    }

    /**
     * 新增保存计划
     */
    @RequiresPermissions("oa:plan:add")
    @Log(title = "计划管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated UserPlan record) {
        int insert = userPlanService.insert(record);
        return toAjax(insert);
    }

    /**
     * 修改计划
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("record", userPlanService.getById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存计划
     */
    @RequiresPermissions("oa:plan:edit")
    @Log(title = "计划管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated UserPlan record) {
        return toAjax(userPlanService.update(record));
    }


    @RequiresPermissions("oa:plan:remove")
    @Log(title = "计划管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(userPlanService.deleteByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}