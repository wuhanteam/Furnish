package com.softeem.test;

import java.util.List;

import org.junit.Test;

import com.softeem.bean.GoodsBean;
import com.softeem.dao.ICategoryDao;
import com.softeem.dao.IGoodsDao;
import com.softeem.dao.impl.CategoryDaoImpl;
import com.softeem.dao.impl.GoodsDaoImpl;

public class TestDao {
	@Test
	public void testCategoryDao() {
		ICategoryDao dao = new CategoryDaoImpl();
		System.out.println(dao.selectAllCategory());
	}
	
	@Test
	public void testGoodsDao(){
		IGoodsDao goodsDao = new GoodsDaoImpl();
		List<GoodsBean> goodsBeans = goodsDao.selectIndexGoods(0, 12);
	
		System.out.println(goodsBeans);
	}
	
	@Test
	public void testGoodsDao1(){
		IGoodsDao goodsDao = new GoodsDaoImpl();
		GoodsBean goods = goodsDao.selectById(1);
	
		System.out.println(goods);
	}
	
	
}
