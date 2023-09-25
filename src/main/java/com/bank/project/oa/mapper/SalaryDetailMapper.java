package com.bank.project.oa.mapper;


import com.bank.project.oa.domain.SalaryDetail;
/**
 * @author: QQ:553039957
 * @Date: 2023/9/25 15:27
 * @Description:
 * 1. gitcode主页： https://gitcode.net/tbb414 （推荐）
 * 2. github主页：https://github.com/doudoutangs
 * 3. gitee(码云)主页：https://gitee.com/spdoudoutang
 */
public interface SalaryDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalaryDetail record);

    int insertSelective(SalaryDetail record);

    SalaryDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalaryDetail record);

    int updateByPrimaryKey(SalaryDetail record);
}