package com.bank.project.oa.service;

import com.bank.project.oa.domain.Asset;
import com.bank.project.oa.domain.BankNotice;

import java.util.List;

/**
 * 业务层
 *
 * @author bank
 */
public interface IBankNoticeService {
    /**
     * 根据条件分页查询列表
     *
     * @param asset 信息
     * @return 信息集合信息
     */
    List<BankNotice> selectList(BankNotice asset);

    BankNotice getById(Long id);


    /**
     * 通过ID删除
     *
     * @param userId ID
     * @return 结果
     */
    int deleteById(String userId);

    /**
     * 批量删除信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    int deleteByIds(String ids) throws Exception;

    /**
     * 保存信息
     *
     * @param recore 信息
     * @return 结果
     */
    int insert(BankNotice recore);

    /**
     * 修改详细信息
     *
     * @param recore 信息
     * @return 结果
     */
    int update(BankNotice recore);


}
