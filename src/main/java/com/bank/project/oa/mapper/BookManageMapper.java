package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.BookManage;
import com.bank.project.oa.domain.MeetManage;

import java.util.List;

public interface BookManageMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByIds(String[] ids);

    int insertSelective(BookManage record);

    BookManage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookManage record);

    List<BookManage> selectByExample(BookManage record);
}