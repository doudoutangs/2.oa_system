package com.bank.project.oa.constant;

/**
 * @author: QQ:553039957
 * @Date: 2023/9/25 15:27
 * @Description:
 * 1. gitcode主页： https://gitcode.net/tbb414 （推荐）
 * 2. github主页：https://github.com/doudoutangs
 * 
 */
public interface AssetConstant {
    /**********资产类型************/
    String TYPE_CONSUMABLE = "0";//消耗品
    String TYPE_FIXED = "1";//固定资产
    String TYPE_TOOLS = "2";//公共工具
    /**********资产状态************/
    String STATUS_NORMAL = "0";//正常
    String STATUS_LEND = "1";//借出
    String STATUS_REPAIR = "2";//维修
    String STATUS_SCRAP = "3";//报废
    /**********资产操作类型************/
    /**
     * 入库
     */
    String OPERATE_ADD = "0";//入库
    /**
     * 领用
     */
    String OPERATE_LEND = "1";//领用
    /**
     * 归还
     */
    String OPERATE_RETURN = "2";//归还
    /**
     * 退库
     */
    String OPERATE_RETREAT = "3";//退库


}
