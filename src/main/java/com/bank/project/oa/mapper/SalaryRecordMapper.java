package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.SalaryRecord;

import java.util.List;

public interface SalaryRecordMapper {
    int deleteByPrimaryKey(Long id);
    int deleteByIds(String[] ids);

    int insertSelective(SalaryRecord record);

    SalaryRecord selectByPrimaryKey(Long id);

    List<SalaryRecord> selectByExample(SalaryRecord record);

    int updateByPrimaryKeySelective(SalaryRecord record);

}