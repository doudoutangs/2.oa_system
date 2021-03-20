package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.SalaryDetail;

public interface SalaryDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalaryDetail record);

    int insertSelective(SalaryDetail record);

    SalaryDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalaryDetail record);

    int updateByPrimaryKey(SalaryDetail record);
}