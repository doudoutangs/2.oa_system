package com.bank.project.oa.domain;

import com.alibaba.fastjson.JSON;
import com.bank.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

public class AssetOperate extends BaseEntity {
    private Long id;

    private Long assetId;

    private String abradeRate;

    private String operateUserId;

    private String operateDate;

    private String operateNum;

    private String operateType;

    private String revertTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAbradeRate() {
        return abradeRate;
    }

    public void setAbradeRate(String abradeRate) {
        this.abradeRate = abradeRate;
    }

    public String getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(String operateUserId) {
        this.operateUserId = operateUserId;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateNum() {
        return operateNum;
    }

    public void setOperateNum(String operateNum) {
        this.operateNum = operateNum;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getRevertTime() {
        return revertTime;
    }

    public void setRevertTime(String revertTime) {
        this.revertTime = revertTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}