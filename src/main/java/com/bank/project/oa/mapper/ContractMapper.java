package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.BookManage;
import com.bank.project.oa.domain.Contract;

import java.util.List;

public interface ContractMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByIds(String[] ids);

    List<Contract> selectByExample(Contract record);


    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Contract record);

}