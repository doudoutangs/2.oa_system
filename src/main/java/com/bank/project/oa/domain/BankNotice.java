package com.bank.project.oa.domain;

import com.alibaba.fastjson.JSON;
import com.bank.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

public class BankNotice extends BaseEntity {
    private Long id;

    private String level;

    private String title;

    private String content;

    private String publishTime;

    private String publishUserId;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(String publishUserId) {
        this.publishUserId = publishUserId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}