package com.bank.project.oa.mapper;

import com.bank.project.oa.domain.Asset;

import java.util.List;
import java.util.Map;

public interface AssetMapper {

    int deleteByIds(String[] ids);

    int deleteById(String id);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(Long id);

    List<Asset> selectByExample(Asset record);

    int updateByPrimaryKey(Asset record);

    Map<String,String> countTypeTotal();

    String countAmount();

    String countTotal();

}