package com.bank.project.oa.service;

import com.bank.project.oa.domain.Asset;
import com.bank.project.oa.domain.AssetOperate;

import java.util.List;

/**
 * 业务层
 *
 * @author bank
 */
public interface IAssetOperateService {
    /**
     * 根据条件分页查询列表
     *
     * @return 信息集合信息
     */
    List<AssetOperate> selectListByAssetId(Long assetId);

    List<AssetOperate> selectList(AssetOperate record);

    AssetOperate getById(Long id);


    /**
     * 保存信息
     *
     * @param asset 信息
     * @return 结果
     */
    int insert(AssetOperate asset);


}
