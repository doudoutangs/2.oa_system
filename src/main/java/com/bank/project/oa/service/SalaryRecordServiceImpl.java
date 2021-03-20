package com.bank.project.oa.service;

import com.bank.common.exception.BusinessException;
import com.bank.common.utils.text.Convert;
import com.bank.framework.aspectj.lang.annotation.DataScope;
import com.bank.project.oa.domain.SalaryRecord;
import com.bank.project.oa.mapper.SalaryRecordMapper;
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
public class SalaryRecordServiceImpl implements ISalaryRecordService {
    private static final Logger log = LoggerFactory.getLogger(ISalaryRecordService.class);

    @Autowired
    private SalaryRecordMapper salaryRecordMapper;

    /**
     * 根据条件分页查询列表
     *
     * @param record 信息
     * @return 信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SalaryRecord> selectList(SalaryRecord record) {
        return salaryRecordMapper.selectByExample(record);
    }

    @Override
    public SalaryRecord getById(Long id) {
        return salaryRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long userId) {
        return salaryRecordMapper.deleteByPrimaryKey(userId);
    }


    /**
     * 批量删除信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteByIds(String ids) throws BusinessException {
        return  salaryRecordMapper.deleteByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存信息
     *
     * @param user 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insert(SalaryRecord user) {
        int rows = salaryRecordMapper.insertSelective(user);
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
    public int update(SalaryRecord record) {
        return salaryRecordMapper.updateByPrimaryKeySelective(record);

    }


}
