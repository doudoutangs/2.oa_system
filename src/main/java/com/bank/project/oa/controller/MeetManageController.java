package com.bank.project.oa.controller;

import com.bank.framework.aspectj.lang.annotation.Log;
import com.bank.framework.aspectj.lang.enums.BusinessType;
import com.bank.framework.web.controller.BaseController;
import com.bank.framework.web.domain.AjaxResult;
import com.bank.framework.web.page.TableDataInfo;
import com.bank.project.oa.domain.MeetManage;
import com.bank.project.oa.service.IMeetManageService;
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
 * 会议信息
 *
 * @author bank
 */
@Controller
@RequestMapping("oa/meet")
public class MeetManageController extends BaseController {
    private String prefix = "oa/meet";

    @Autowired
    private IMeetManageService meetManageService;
    @Autowired
    private IUserService userService;

    @RequiresPermissions("oa:meet:view")
    @GetMapping()
    public String asset(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/index";
    }

    @RequiresPermissions("oa:meet:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MeetManage record) {
        startPage();
        List<MeetManage> list = meetManageService.selectList(record);
        return getDataTable(list);
    }


    /**
     * 新增会议
     */
    @GetMapping("/add")
    public String add(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/add";
    }
    /**
     * 新增保存会议
     */
    @RequiresPermissions("oa:meet:add")
    @Log(title = "会议管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MeetManage record) {
        //1.添加会议
        int insert = meetManageService.insert(record);
        return toAjax(insert);
    }
    /**
     * 修改会议
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("record", meetManageService.getById(id));
        return prefix + "/edit";
    }
    /**
     * 会议审批
     */
    @RequiresPermissions("oa:meet:approval")
    @GetMapping("/approval/{id}")
    public String approval(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("record", meetManageService.getById(id));
        return prefix + "/approval";
    }

    /**
     * 修改保存会议
     */
    @RequiresPermissions("oa:meet:edit")
    @Log(title = "会议管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MeetManage record) {
        return toAjax(meetManageService.update(record));
    }


    @RequiresPermissions("oa:meet:remove")
    @Log(title = "会议管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(meetManageService.deleteByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}