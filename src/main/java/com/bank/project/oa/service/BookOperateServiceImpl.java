package com.bank.project.oa.service;

import com.bank.framework.aspectj.lang.annotation.DataScope;
import com.bank.project.oa.domain.BookOperate;
import com.bank.project.oa.mapper.BookOperateMapper;
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
public class BookOperateServiceImpl implements IBookOperateService {
    private static final Logger log = LoggerFactory.getLogger(IBookOperateService.class);

    @Autowired
    private BookOperateMapper bookOperateMapper;

    /**
     * 根据条件分页查询列表
     *
     * @param record 信息
     * @return 信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<BookOperate> selectList(BookOperate record) {
        return bookOperateMapper.selectByExample(record);
    }

    @Override
    public BookOperate getById(Long id) {
        return bookOperateMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增保存信息
     *
     * @param user 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insert(BookOperate user) {
        int rows = bookOperateMapper.insertSelective(user);
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
    public int update(BookOperate record) {
        return bookOperateMapper.updateByPrimaryKeySelective(record);

    }


}
