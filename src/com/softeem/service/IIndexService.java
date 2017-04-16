package com.softeem.service;

import java.util.List;

import com.softeem.bean.CategoryBean;
import com.softeem.bean.GoodsBean;

public interface IIndexService {
	List<CategoryBean> getCategory();
	
	List<GoodsBean> getGoods();
}
