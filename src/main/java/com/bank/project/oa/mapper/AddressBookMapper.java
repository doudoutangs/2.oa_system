package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.AddressBook;
import com.bank.project.oa.domain.Asset;

import java.util.List;

public interface AddressBookMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByIds(String[] ids);

    int insertSelective(AddressBook record);

    AddressBook selectByPrimaryKey(Long id);

    List<AddressBook> selectByExample(AddressBook record);

    int updateByPrimaryKeySelective(AddressBook record);

}