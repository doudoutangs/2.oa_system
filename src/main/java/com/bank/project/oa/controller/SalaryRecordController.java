package com.bank.project.oa.controller;

import com.bank.common.utils.StringUtils;
import com.bank.framework.aspectj.lang.annotation.Log;
import com.bank.framework.aspectj.lang.enums.BusinessType;
import com.bank.framework.web.controller.BaseController;
import com.bank.framework.web.domain.AjaxResult;
import com.bank.framework.web.page.TableDataInfo;
import com.bank.project.oa.domain.SalaryRecord;
import com.bank.project.oa.service.ISalaryRecordService;
import com.bank.project.oa.service.ISalaryRecordService;
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
 * 薪资记录信息
 *
 * @author bank
 */
@Controller
@RequestMapping("oa/salary")
public class SalaryRecordController extends BaseController {
    private String prefix = "oa/salary";

    @Autowired
    private ISalaryRecordService salaryRecordService;
    @Autowired
    private IUserService userService;

    @RequiresPermissions("salary:record:view")
    @GetMapping()
    public String asset(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/index";
    }

    @RequiresPermissions("salary:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SalaryRecord record) {
        startPage();
        String salaryDate = record.getSalaryDate();
        if(StringUtils.isNotBlank(salaryDate)){
            record.setSalaryDate(salaryDate.substring(0,7));
        }
        List<SalaryRecord> list = salaryRecordService.selectList(record);
        return getDataTable(list);
    }


    /**
     * 新增薪资记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap,User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        mmap.put("list", list);
        return prefix + "/add";
    }
    /**
     * 新增保存薪资记录
     */
    @RequiresPermissions("salary:record:add")
    @Log(title = "薪资记录管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SalaryRecord record) {
        record.setSalaryDate(record.getSalaryDate().substring(0,7));
        //1.添加薪资记录
        List<SalaryRecord> salaryRecords = salaryRecordService.selectList(record);
        if(salaryRecords.size()>0){
            return AjaxResult.error("该员工"+record.getSalaryDate()+"已存在记录");
        }
        int insert = salaryRecordService.insert(record);
        return toAjax(insert);
    }
    /**
     * 修改薪资记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("record", salaryRecordService.getById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存薪资记录
     */
    @RequiresPermissions("salary:record:edit")
    @Log(title = "薪资记录管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SalaryRecord record) {
        return toAjax(salaryRecordService.update(record));
    }


    @RequiresPermissions("salary:record:remove")
    @Log(title = "薪资记录管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(salaryRecordService.deleteByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}