package com.bank.project.oa.controller;

import com.bank.common.utils.StringUtils;
import com.bank.framework.aspectj.lang.annotation.Log;
import com.bank.framework.aspectj.lang.enums.BusinessType;
import com.bank.framework.web.controller.BaseController;
import com.bank.framework.web.domain.AjaxResult;
import com.bank.framework.web.page.TableDataInfo;
import com.bank.project.oa.domain.UserDoc;
import com.bank.project.oa.service.IUserDocService;
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
 * 人事档案信息
 *
 * @author bank
 */
@Controller
@RequestMapping("oa/userdoc")
public class UserDocController extends BaseController {
    private String prefix = "oa/userdoc";

    @Autowired
    private IUserDocService userDocService;
    @Autowired
    private IUserService userService;

    @RequiresPermissions("oa:userdoc:view")
    @GetMapping()
    public String asset(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/index";
    }

    @RequiresPermissions("oa:userdoc:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserDoc record) {
        startPage();
        List<UserDoc> list = userDocService.selectList(record);
        return getDataTable(list);
    }


    /**
     * 新增人事档案
     */
    @GetMapping("/add")
    public String add(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/add";
    }
    /**
     * 新增保存人事档案
     */
    @RequiresPermissions("oa:userdoc:add")
    @Log(title = "人事档案管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated UserDoc record) {
        Long userId = record.getUserId();
        record.setUserNo(StringUtils.leftPad(userId.toString(),4,"0"));
        record.setName(userService.selectUserById(userId).getUserName());
        int insert = userDocService.insert(record);
        return toAjax(insert);
    }

    /**
     * 修改人事档案
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("record", userDocService.getById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存人事档案
     */
    @RequiresPermissions("oa:userdoc:edit")
    @Log(title = "人事档案管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated UserDoc record) {
        return toAjax(userDocService.update(record));
    }


    @RequiresPermissions("oa:userdoc:remove")
    @Log(title = "人事档案管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(userDocService.deleteByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}