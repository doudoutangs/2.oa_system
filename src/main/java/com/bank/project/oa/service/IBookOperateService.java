package com.bank.project.oa.service;

import com.bank.project.oa.domain.BookOperate;

import java.util.List;

/**
 * 业务层
 *
 * @author bank
 */
public interface IBookOperateService {
    /**
     * 根据条件分页查询列表
     *
     * @param record 信息
     * @return 信息集合信息
     */
    List<BookOperate> selectList(BookOperate record);

    BookOperate getById(Long id);



    /**
     * 保存信息
     *
     * @param recore 信息
     * @return 结果
     */
    int insert(BookOperate recore);

    /**
     * 修改详细信息
     *
     * @param recore 信息
     * @return 结果
     */
    int update(BookOperate recore);


}
