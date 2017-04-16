package com.softeem.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softeem.dao.IAppContentInfoQueryDao;
import com.softeem.dao.impl.AppContentInfoQueryDaoImpl;
import com.softeem.service.IAppContentInfoQueryService;

@Service("appContentInfoQueryService")
public class AppContentInfoQueryService implements IAppContentInfoQueryService {
	@Resource(name = "appContentInfoQueryDaoImpl")
	private IAppContentInfoQueryDao dao;

	/**
	 * 查询推荐栏
	 */
	@Override
	public List<Map<String, String>> queryRecommColumn() {
		return dao.queryRecommColumn();
	}

	/**
	 * 查询置顶项
	 */
	@Override
	public List<Map<String, String>> queryPageTopInfo() {
		return dao.queryPageTopInfo();
	}

	/**
	 * 最新
	 */
	@Override
	public List<Map<String, String>> queryLatestYiyuanInfo() {
		return dao.queryLatestYiyuanInfo();
	}

	/**
	 * 最快
	 */
	@Override
	public List<Map<String, String>> queryFastestYiyuanInfo() {
		return dao.queryFastestYiyuanInfo();
	}

	/**
	 * 最火
	 */
	@Override
	public List<Map<String, String>> queryHottestYiyuanInfo() {
		return dao.queryHottestYiyuanInfo();
	}

	/**
	 * 最贵
	 */
	@Override
	public List<Map<String, String>> queryYiyuanInfoByPriceDesc() {
		return dao.queryYiyuanInfoByPriceDesc();
	}

	/**
	 * 最便宜
	 */
	@Override
	public List<Map<String, String>> queryYiyuanInfoByPriceAsc() {
		return dao.queryYiyuanInfoByPriceAsc();
	}

	/**
	 * 中奖历史列表
	 */
	@Override
	public List<Map<String, String>> queryZjInfolist() {
		return dao.queryZjInfolist();
	}

	/**
	 * 商品详情
	 */
	@Override
	public Map<String, String> queryOneYiyuanInfo(String yid) {
		return dao.queryOneYiyuanInfo(yid);
	}

	/**
	 * 个人中奖纪录
	 */
	@Override
	public List<Map<String, String>> queryZjInfoByUserID(String userID) {
		return dao.queryZjInfoByUserID(userID);
	}

	/**
	 * 查询充值记录
	 */
	@Override
	public List<Map<String, String>> queryRechargeRecordInfo(String userID) {
		return dao.queryRechargeRecordInfo(userID);
	}

	/**
	 * 查询用户信息
	 */
	@Override
	public Map<String, String> queryCustomerInfo(String cid) {
		return dao.queryCustomerInfo(cid);
	}

	/**
	 * 查询购物车
	 */
	@Override
	public List<Map<String, String>> queryShoppingCartInfo(String cid) {
		return dao.queryShoppingCartInfo(cid);
	}

}
