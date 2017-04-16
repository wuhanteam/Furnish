package com.softeem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softeem.bean.GoodsBean;
import com.softeem.dao.IGoodsDao;
import com.softeem.dao.impl.GoodsDaoImpl;
import com.softeem.service.ISingleService;

@Service("singleServiceImpl")
public class SingleServiceImpl implements ISingleService {

	@Resource(name = "goodsDaoImpl")
	private IGoodsDao dao;

	// 查询: dao
	@Override
	public GoodsBean getSingleGoods(String goodsIdStr) {
		int goodsId = 0;
		try {
			goodsId = Integer.parseInt(goodsIdStr);
		} catch (Exception e) {
		}

		// 调用goodsdao

		return dao.selectById(goodsId);
	}

}
