package com.bank.project.oa.controller;

import com.bank.framework.aspectj.lang.annotation.Log;
import com.bank.framework.aspectj.lang.enums.BusinessType;
import com.bank.framework.web.controller.BaseController;
import com.bank.framework.web.domain.AjaxResult;
import com.bank.framework.web.page.TableDataInfo;
import com.bank.project.oa.domain.AddressBook;
import com.bank.project.oa.domain.Asset;
import com.bank.project.oa.service.IAddressBookService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: QQ:553039957
 * @Date: 2023/9/25 15:26
 * @Description:
 * 1. gitcode主页： https://gitcode.net/tbb414 （推荐）
 * 2. github主页：https://github.com/doudoutangs
 * 3. gitee(码云)主页：https://gitee.com/spdoudoutang
 */
@Controller
@RequestMapping("address/book")
public class AddressBookController extends BaseController {
    private String prefix = "oa/address";

    @Autowired
    private IAddressBookService addressBookService;

    @RequiresPermissions("address:book:view")
    @GetMapping()
    public String asset() {
        return prefix + "/address";
    }

    @RequiresPermissions("address:book:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AddressBook asset) {
        startPage();
        List<AddressBook> list = addressBookService.selectList(asset);
        return getDataTable(list);
    }


    /**
     * 新增通讯录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }


    /**
     * 新增保存通讯录
     */
    @RequiresPermissions("address:book:add")
    @Log(title = "通讯录管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated AddressBook asset) {
        //1.添加通讯录
        int insert = addressBookService.insert(asset);
        return toAjax(insert);
    }

    /**
     * 修改通讯录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("address", addressBookService.getById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存通讯录
     */
    @RequiresPermissions("address:book:edit")
    @Log(title = "通讯录管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated AddressBook asset) {
        return toAjax(addressBookService.update(asset));
    }


    @RequiresPermissions("address:book:remove")
    @Log(title = "通讯录管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(addressBookService.deleteByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

}