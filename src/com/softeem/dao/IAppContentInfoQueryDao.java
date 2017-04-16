package com.softeem.dao;

import java.util.List;
import java.util.Map;

public interface IAppContentInfoQueryDao {
	
	// 推荐banner
	public List<Map<String,String>> queryRecommColumn();
	
	// 置顶
	public List<Map<String,String>> queryPageTopInfo();
	
	// 最新
	public List<Map<String,String>> queryLatestYiyuanInfo();
	
	// 最快开奖
	public List<Map<String,String>> queryFastestYiyuanInfo();
	
	// 最热门
	public List<Map<String,String>> queryHottestYiyuanInfo();
	
	//降序 最贵
	public List<Map<String,String>> queryYiyuanInfoByPriceDesc();
	
	// 升序最便宜
	public List<Map<String,String>> queryYiyuanInfoByPriceAsc();
	
	// 查询中奖信息
	public List<Map<String,String>> queryZjInfolist();
	
	// 商品详情
	public Map<String,String> queryOneYiyuanInfo(String yid);
	
	// 查询中奖信息
	public List<Map<String,String>> queryZjInfoByUserID(String userID);
	
	// 查询充值记录
	public List<Map<String,String>> queryRechargeRecordInfo(String userID);
	
	// 查询个人信息
	public Map<String,String> queryCustomerInfo(String cid);
	
	// 查询购物车
	public List<Map<String,String>> queryShoppingCartInfo(String cid);
}
