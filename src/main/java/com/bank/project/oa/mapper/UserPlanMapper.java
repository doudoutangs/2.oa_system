package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.SalaryRecord;
import com.bank.project.oa.domain.UserPlan;

import java.util.List;

public interface UserPlanMapper {
    int deleteByPrimaryKey(Long id);
    int deleteByIds(String[] ids);

    int insertSelective(UserPlan record);

    UserPlan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPlan record);

    List<UserPlan> selectByExample(UserPlan record);
}