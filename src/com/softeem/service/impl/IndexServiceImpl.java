package com.softeem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softeem.bean.CategoryBean;
import com.softeem.bean.GoodsBean;
import com.softeem.dao.ICategoryDao;
import com.softeem.dao.IGoodsDao;
import com.softeem.dao.impl.CategoryDaoImpl;
import com.softeem.dao.impl.GoodsDaoImpl;
import com.softeem.service.IIndexService;

@Service("indexServiceImpl")
public class IndexServiceImpl implements IIndexService {
	@Resource(name = "categoryDaoImpl")
	private ICategoryDao dao;

	@Resource(name = "goodsDaoImpl")
	private IGoodsDao goodsdao;

	/**
	 * 获取分类信息
	 */
	@Override
	public List<CategoryBean> getCategory() {

		return dao.selectAllCategory();
	}

	/**
	 * 获取首页的商品信息
	 */
	@Override
	public List<GoodsBean> getGoods() {

		return goodsdao.selectIndexGoods(0, 12);
	}

}
