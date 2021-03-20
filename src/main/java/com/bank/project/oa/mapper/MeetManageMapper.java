package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.MeetManage;
import com.bank.project.oa.domain.SalaryRecord;

import java.util.List;

public interface MeetManageMapper {
    int deleteByPrimaryKey(Long id);
    int deleteByIds(String[] ids);

    int insertSelective(MeetManage record);

    MeetManage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MeetManage record);

    List<MeetManage> selectByExample(MeetManage record);
}