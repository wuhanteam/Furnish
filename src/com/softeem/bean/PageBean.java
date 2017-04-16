package com.softeem.bean;

import java.util.List;

import com.softeem.service.ICategoryService;
import com.softeem.service.impl.CategoryServiceImpl;

/**
 * 封装与分页相关的数据
 * 
 * @author Edward
 *
 */
public class PageBean {
	// 商品数据
	private List<GoodsBean> goodsList;
	// 页码数据
	private List<Integer> pageList;
	// 总页数
	private int pageCount;
	// 当前页
	private int currentPage;

	public PageBean(List<GoodsBean> goodsList, List<Integer> pageList,
			int pageCount, int currentPage) {
		super();
		this.goodsList = goodsList;
		this.pageList = pageList;
		this.pageCount = pageCount;
		this.currentPage = currentPage;
	}

	public PageBean() {
		super();
	}

	public List<GoodsBean> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsBean> goodsList) {
		this.goodsList = goodsList;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "PageBean [goodsList=" + goodsList + ", pageList=" + pageList
				+ ", pageCount=" + pageCount + ", currentPage=" + currentPage
				+ "]";
	}

}
