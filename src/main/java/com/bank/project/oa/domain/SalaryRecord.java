package com.bank.project.oa.domain;

import com.bank.framework.web.domain.BaseEntity;

public class SalaryRecord extends BaseEntity {
    private Long id;

    private Long userId;
    private String userName;

    private String salaryDate;

    private Float mustSalary;

    private Float realitySalary;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(String salaryDate) {
        this.salaryDate = salaryDate;
    }

    public Float getMustSalary() {
        return mustSalary;
    }

    public void setMustSalary(Float mustSalary) {
        this.mustSalary = mustSalary;
    }

    public Float getRealitySalary() {
        return realitySalary;
    }

    public void setRealitySalary(Float realitySalary) {
        this.realitySalary = realitySalary;
    }

}