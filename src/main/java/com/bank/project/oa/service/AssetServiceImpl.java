package com.bank.project.oa.service;

import com.alibaba.fastjson.JSONObject;
import com.bank.common.exception.BusinessException;
import com.bank.common.utils.text.Convert;
import com.bank.framework.aspectj.lang.annotation.DataScope;
import com.bank.project.oa.constant.AssetConstant;
import com.bank.project.oa.domain.Asset;
import com.bank.project.oa.mapper.AssetMapper;
import com.bank.project.oa.mapper.AssetOperateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 业务层处理
 *
 * @author bank
 */
@Service
public class AssetServiceImpl implements IAssetService {
    private static final Logger log = LoggerFactory.getLogger(IAssetService.class);

    @Autowired
    private AssetMapper assetMapper;
    @Autowired
    private AssetOperateMapper assetOperateMapper;

    /**
     * 根据条件分页查询列表
     *
     * @param asset 信息
     * @return 信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<Asset> selectList(Asset asset) {
        return assetMapper.selectByExample(asset);
    }

    @Override
    public Asset getById(Long id) {
        return assetMapper.selectByPrimaryKey(id);
    }


    /**
     * 通过ID删除
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deleteById(String id) {
        return assetMapper.deleteById(id);
    }

    /**
     * 批量删除信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteByIds(String ids) throws BusinessException {
        return assetMapper.deleteByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存信息
     *
     * @param user 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insert(Asset user) {
        int rows = assetMapper.insertSelective(user);
        return rows;
    }

    /**
     * 修改保存信息
     *
     * @param asset 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int update(Asset asset) {
        return assetMapper.updateByPrimaryKey(asset);

    }

    @Override
    public JSONObject stat() {
        String amount = assetMapper.countAmount();
        String total = assetMapper.countTotal();
//        Map<String, String> typeNum = assetMapper.countTypeTotal();
        //操作统计
        String lendNum = assetOperateMapper.countTypeTotal(AssetConstant.OPERATE_LEND);
        String returnNum = assetOperateMapper.countTypeTotal(AssetConstant.OPERATE_RETURN);
        List<List<String>> addlist = null;
        List<List<String>> reduceList = null;
        //最近30天操作资产数量,入库
        List<Map<String, String>> dayOperateAddNum = assetOperateMapper.count30DayOperateTotal(AssetConstant.OPERATE_LEND);
        addlist = buildStat(dayOperateAddNum);
        //最近30天操作资产数量,出库
        List<Map<String, String>> dayOperateReduceNum = assetOperateMapper.count30DayOperateTotal(AssetConstant.OPERATE_RETURN);
        reduceList = buildStat(dayOperateReduceNum);
        JSONObject data = new JSONObject();
        data.put("total", total);
        data.put("amount", amount);
        data.put("lendNum", lendNum);
        data.put("returnNum", returnNum);
        data.put("dayOperateAddNum", addlist.toArray());
        data.put("dayOperateReduceNum", reduceList.toArray());
//        data.put("typeNum", typeNum);
        return data;
    }

    private List<List<String>> buildStat(List<Map<String, String>> list) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        int size = list.size();
        List<List<String>> record = new ArrayList<List<String>>(size);
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            String day = String.valueOf(map.get("day"));
            String num = String.valueOf(map.get("num"));
            try {
                day = String.valueOf(format.parse(day).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<String> t = new ArrayList<String>(2);
            t.add(day);
            t.add(num);
            record.add(t);
        }
        return record;
    }


}
