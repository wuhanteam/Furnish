package com.softeem.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softeem.bean.GoodsBean;
import com.softeem.bean.PageBean;
import com.softeem.dao.IGoodsDao;
import com.softeem.dao.impl.GoodsDaoImpl;
import com.softeem.service.ICategoryService;

@Service("categoryServiceImpl")
public class CategoryServiceImpl implements ICategoryService {
	@Resource(name = "goodsDaoImpl")
	private IGoodsDao dao;

	@Override
	public List<GoodsBean> getGoodsByCate(String cateIdStr) {
		int cateId = -1;
		try {
			cateId = Integer.parseInt(cateIdStr);
		} catch (Exception e) {
			cateId = -1;
		}

		return dao.selectByCate(cateId);
	}

	@Override
	public List<GoodsBean> getGoodsByPageAndCate(String pageNumStr, String pageSizeStr, String cateIdStr) {
		int pageNum = parseInt(pageNumStr, 1);
		int pageSize = parseInt(pageSizeStr, 2);
		int cateId = parseInt(cateIdStr, -1);

		List<GoodsBean> goodsBeanList = dao.selectByPageAndCate(pageNum, pageSize, cateId);

		for (GoodsBean goodsBean : goodsBeanList) {
			System.out.println(goodsBean);
		}

		return goodsBeanList;
	}

	// 将字符串转成int
	public static int parseInt(String intStr, int defaultValue) {
		try {
			return Integer.parseInt(intStr);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	@Override
	public List<Integer> getPageList(String pageNumStr, String pageSizeStr, String cateIdStr) {
		int pageNum = parseInt(pageNumStr, 1);
		int pageSize = parseInt(pageSizeStr, 2);
		int cateId = parseInt(cateIdStr, -1);

		// 页码数量
		int totalPage = dao.selectTotalPage(cateId, pageSize);
		// 8 页 , 当前页 :1
		// 1 2 3
		// 8页, 当前页 : 2
		// 1 2 3 4
		// 8页, 当前页 : 3
		// 1 2 3 4 5
		// 8页, 当前页 : 4
		// 2 3 4 5 6
		// 8页, 当前页 : 7
		// 5 6 7 8
		List<Integer> pageList = new ArrayList<Integer>();
		for (int i = pageNum - 2; i <= pageNum + 2; i++) {
			if (i >= 1 && i <= totalPage) {
				pageList.add(i);
			}
		}

		return pageList;
	}

	@Override
	public int getPageCount(String pageSizeStr, String cateIdStr) {
		int pageSize = parseInt(pageSizeStr, 2);
		int cateId = parseInt(cateIdStr, -1);
		return dao.selectTotalPage(cateId, pageSize);
	}

	@Override
	public PageBean getPageBean(String pageNumStr, String pageSizeStr, String cateIdStr) {
		// 查询当前页的商品数据
		List<GoodsBean> goodsList = getGoodsByPageAndCate(pageNumStr, pageSizeStr, cateIdStr);

		// 查询页码数据:
		List<Integer> pageList = getPageList(pageNumStr, pageSizeStr, cateIdStr);
		// 获取总页数:
		int pageCount = getPageCount(pageSizeStr, cateIdStr);
		// 当前页:
		int currentPage = parseInt(pageNumStr, 1);

		PageBean pageBean = new PageBean(goodsList, pageList, pageCount, currentPage);
		return pageBean;
	}

}
