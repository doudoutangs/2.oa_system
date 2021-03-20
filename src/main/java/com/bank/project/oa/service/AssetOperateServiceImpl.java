package com.bank.project.oa.service;

import com.bank.common.exception.BusinessException;
import com.bank.common.utils.text.Convert;
import com.bank.framework.aspectj.lang.annotation.DataScope;
import com.bank.project.oa.domain.Asset;
import com.bank.project.oa.domain.AssetOperate;
import com.bank.project.oa.mapper.AssetMapper;
import com.bank.project.oa.mapper.AssetOperateMapper;
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
public class AssetOperateServiceImpl implements IAssetOperateService {
    private static final Logger log = LoggerFactory.getLogger(IAssetOperateService.class);

    @Autowired
    private AssetOperateMapper assetMapper;

    /**
     * 根据条件分页查询列表
     *
     * @return 信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<AssetOperate> selectListByAssetId(Long assetId) {
        return assetMapper.selectListByAssetId(assetId);
    }

    @Override
    public List<AssetOperate> selectList(AssetOperate record) {
        return assetMapper.selectList(record);
    }

    @Override
    public AssetOperate getById(Long id) {
        return assetMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增保存信息
     *
     * @param user 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insert(AssetOperate user) {
        int rows = assetMapper.insertSelective(user);
        return rows;
    }

}
