package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.BookOperate;
import com.bank.project.oa.domain.MeetManage;

import java.util.List;

public interface BookOperateMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(BookOperate record);

    BookOperate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookOperate record);

    List<BookOperate> selectByExample(BookOperate record);
}