package com.softeem.dao;

import java.util.List;

import com.softeem.bean.CategoryBean;

public interface ICategoryDao {
	List<CategoryBean> selectAllCategory();
}
