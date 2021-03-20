package com.bank.project.oa.controller;

import com.bank.framework.aspectj.lang.annotation.Log;
import com.bank.framework.aspectj.lang.enums.BusinessType;
import com.bank.framework.web.controller.BaseController;
import com.bank.framework.web.domain.AjaxResult;
import com.bank.framework.web.page.TableDataInfo;
import com.bank.project.oa.domain.BookManage;
import com.bank.project.oa.service.IBookManageService;
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
 * 图书信息
 *
 * @author bank
 */
@Controller
@RequestMapping("oa/book")
public class BookManageController extends BaseController {
    private String prefix = "oa/book";

    @Autowired
    private IBookManageService bookManageService;
    @Autowired
    private IUserService userService;

    @RequiresPermissions("oa:book:view")
    @GetMapping()
    public String asset(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/index";
    }

    @RequiresPermissions("oa:book:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BookManage record) {
        startPage();
        List<BookManage> list = bookManageService.selectList(record);
        return getDataTable(list);
    }


    /**
     * 新增图书
     */
    @GetMapping("/add")
    public String add(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/add";
    }
    /**
     * 新增保存图书
     */
    @RequiresPermissions("oa:book:add")
    @Log(title = "图书管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated BookManage record) {
        int insert = bookManageService.insert(record);
        return toAjax(insert);
    }
    /**
     * 修改图书
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("record", bookManageService.getById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存图书
     */
    @RequiresPermissions("oa:book:edit")
    @Log(title = "图书管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated BookManage record) {
        return toAjax(bookManageService.update(record));
    }


    @RequiresPermissions("oa:book:remove")
    @Log(title = "图书管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(bookManageService.deleteByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}