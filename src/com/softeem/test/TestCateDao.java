package com.softeem.test;

import java.util.List;

import org.junit.Test;

import com.softeem.bean.GoodsBean;
import com.softeem.dao.impl.GoodsDaoImpl;

public class TestCateDao {
	public static void main(String[] args) {
		GoodsDaoImpl daoImpl = new GoodsDaoImpl();
//		List<GoodsBean> goodsBeans = daoImpl.selectByPageAndCate(3, 4, -1);
//		for (GoodsBean goodsBean : goodsBeans) {
//			System.out.println(goodsBean);
//		}
		
		System.out.println(daoImpl.selectTotalPage(6, 4));
	}

}
