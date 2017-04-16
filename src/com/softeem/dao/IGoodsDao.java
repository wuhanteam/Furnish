package com.softeem.dao;

import java.util.List;

import com.softeem.bean.GoodsBean;

public interface IGoodsDao {
	// 首页 : 1-12 
	List<GoodsBean> selectIndexGoods(int begin,int end);
	
	// 分类查询(分页查询)  
	List<GoodsBean> selectByCate(int cateId);
	
	List<GoodsBean> selectByPageAndCate(int pageNum,int pageSize,int cateId);
	
	
	// 商品详情 : 单个商品
	GoodsBean selectById(int goodsId);
	
	//获取总页数
	int selectTotalPage(int cateId,int pageSize);
	
}
