package com.softeem.service;

import java.util.List;

import com.softeem.bean.GoodsInfoBean;
import com.softeem.utils.VOResult;

public interface IGoodsService {
	
	/**
	 * 新增
	 * @param info
	 * @return
	 */
	int addGoodsInfo(GoodsInfoBean info);

	/**
	 * 批量或单一删除
	 * @param gIDs
	 * @return
	 */
	int delGoodsByID(String[] gIDs);
	
	/**
	 * 更新商品信息
	 * @param info
	 * @return
	 */
	int updateGoodsInfo(GoodsInfoBean info);
	
	/**
	 * 根据ID查询单一商品
	 * @param gID
	 * @return
	 */
	GoodsInfoBean queryGoodsByID(String gID);
	
	/**
	 * 查询所有商品
	 * @return
	 */
	List<GoodsInfoBean> queryAllGoods();

	
	VOResult queryAllGoods(String sql, int beginPage, int pageSize);

	int queryGoodsByGSID(String gsid);
	
	
}
