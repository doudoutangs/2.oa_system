package com.bank.project.oa.mapper;

import com.bank.project.oa.domain.BankNotice;

import java.util.List;

public interface BankNoticeMapper {
    int deleteById(String id);

    int deleteByIds(String[] ids);

    int insertSelective(BankNotice record);

    BankNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BankNotice record);

    List<BankNotice> selectByExample(BankNotice record);

}