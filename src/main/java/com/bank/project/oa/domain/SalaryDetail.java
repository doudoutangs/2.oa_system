package com.bank.project.oa.domain;

import com.bank.framework.web.domain.BaseEntity;

public class SalaryDetail   extends BaseEntity {
    private Long id;

    private String type;

    private String costNo;

    private String costName;

    private Float costAmount;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCostNo() {
        return costNo;
    }

    public void setCostNo(String costNo) {
        this.costNo = costNo;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public Float getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(Float costAmount) {
        this.costAmount = costAmount;
    }

}