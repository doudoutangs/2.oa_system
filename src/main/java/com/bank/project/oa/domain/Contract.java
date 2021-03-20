package com.bank.project.oa.domain;

import com.bank.framework.web.domain.BaseEntity;


public class Contract extends BaseEntity {
    private Long id;

    private String name;

    private String partA;

    private String partB;

    private String signDate;

    private String personA;

    private String personB;

    private Float amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getPersonA() {
        return personA;
    }

    public void setPersonA(String personA) {
        this.personA = personA;
    }

    public String getPersonB() {
        return personB;
    }

    public void setPersonB(String personB) {
        this.personB = personB;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}