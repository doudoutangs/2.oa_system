package com.bank.project.oa.mapper;

import com.bank.project.oa.domain.AssetOperate;

import java.util.List;
import java.util.Map;

public interface AssetOperateMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(AssetOperate record);

    AssetOperate selectByPrimaryKey(Long id);

    List<AssetOperate> selectListByAssetId(Long assetId);

    List<AssetOperate> selectList(AssetOperate record);

    String countTypeTotal(String operateType);

    List<Map<String, String>> count30DayOperateTotal(String operateType);

    int updateByPrimaryKeySelective(AssetOperate record);

}