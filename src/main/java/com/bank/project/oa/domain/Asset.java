package com.bank.project.oa.domain;

import com.alibaba.fastjson.JSON;
import com.bank.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
public class Asset  extends BaseEntity {
    private Long id;

    private String assetNo;

    private String assetName;

    private String num;

    private String numUnit;

    private Double price;

    private String storageTime;

    private String addUserId;

    private String addTime;

    private String revertTime;

    private String abradeRate;

    private String assetType;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNumUnit() {
        return numUnit;
    }

    public void setNumUnit(String numUnit) {
        this.numUnit = numUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getRevertTime() {
        return revertTime;
    }

    public void setRevertTime(String revertTime) {
        this.revertTime = revertTime;
    }

    public String getAbradeRate() {
        return abradeRate;
    }

    public void setAbradeRate(String abradeRate) {
        this.abradeRate = abradeRate;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}