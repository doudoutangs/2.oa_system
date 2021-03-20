package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.Contract;
import com.bank.project.oa.domain.UserDoc;

import java.util.List;

public interface UserDocMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByIds(String[] ids);

    List<UserDoc> selectByExample(UserDoc record);

    int insertSelective(UserDoc record);

    UserDoc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDoc record);

}