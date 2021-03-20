package com.bank.project.oa.service;

import com.bank.common.exception.BusinessException;
import com.bank.common.utils.text.Convert;
import com.bank.framework.aspectj.lang.annotation.DataScope;
import com.bank.project.oa.domain.BookManage;
import com.bank.project.oa.mapper.BookManageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 业务层处理
 *
 * @author bank
 */
@Service
public class BookManageServiceImpl implements IBookManageService {
    private static final Logger log = LoggerFactory.getLogger(IBookManageService.class);

    @Autowired
    private BookManageMapper bookManageMapper;

    /**
     * 根据条件分页查询列表
     *
     * @param record 信息
     * @return 信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<BookManage> selectList(BookManage record) {
        return bookManageMapper.selectByExample(record);
    }

    @Override
    public BookManage getById(Long id) {
        return bookManageMapper.selectByPrimaryKey(id);
    }


    /**
     * 通过ID删除
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deleteById(Long id) {
        return bookManageMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteByIds(String ids) throws BusinessException {
        return  bookManageMapper.deleteByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存信息
     *
     * @param user 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insert(BookManage user) {
        int rows = bookManageMapper.insertSelective(user);
        return rows;
    }

    /**
     * 修改保存信息
     *
     * @param record 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int update(BookManage record) {
        return bookManageMapper.updateByPrimaryKeySelective(record);

    }


}
