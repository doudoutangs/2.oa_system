package com.bank.project.oa.service;

import com.bank.common.exception.BusinessException;
import com.bank.common.utils.text.Convert;
import com.bank.framework.aspectj.lang.annotation.DataScope;
import com.bank.project.oa.domain.AddressBook;
import com.bank.project.oa.mapper.AddressBookMapper;
import com.bank.project.oa.mapper.AddressBookMapper;
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
public class AddressBookServiceImpl implements IAddressBookService {
    private static final Logger log = LoggerFactory.getLogger(IAddressBookService.class);

    @Autowired
    private AddressBookMapper addressBookMapper;

    /**
     * 根据条件分页查询列表
     *
     * @param record 信息
     * @return 信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<AddressBook> selectList(AddressBook record) {
        return addressBookMapper.selectByExample(record);
    }

    @Override
    public AddressBook getById(Long id) {
        return addressBookMapper.selectByPrimaryKey(id);
    }


    /**
     * 通过ID删除
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deleteById(Long id) {
        return addressBookMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteByIds(String ids) throws BusinessException {
        return  addressBookMapper.deleteByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存信息
     *
     * @param user 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insert(AddressBook user) {
        int rows = addressBookMapper.insertSelective(user);
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
    public int update(AddressBook record) {
        return addressBookMapper.updateByPrimaryKeySelective(record);

    }


}
