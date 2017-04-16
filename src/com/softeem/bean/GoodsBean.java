package com.softeem.bean;

import java.io.Serializable;
import java.util.List;

public class GoodsBean implements Serializable {
	private int goods_id;
	private String goods_name;
	private double goods_price;
	private String goods_desc;
	private int cate_id;
	private List<String> imageList;
	private List<String> sizeList;

	public List<String> getSizeList() {
		return sizeList;
	}

	public void setSizeList(List<String> sizeList) {
		this.sizeList = sizeList;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_desc() {
		return goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> iamgeList) {
		this.imageList = iamgeList;
	}

	public GoodsBean(int goods_id, String goods_name, double goods_price,
			String goods_desc, int cate_id, List<String> iamgeList) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_desc = goods_desc;
		this.cate_id = cate_id;
		this.imageList = iamgeList;
	}

	@Override
	public String toString() {
		return "GoodsBean [goods_id=" + goods_id + ", goods_name=" + goods_name
				+ ", goods_price=" + goods_price + ", goods_desc=" + goods_desc
				+ ", cate_id=" + cate_id + ", imageList=" + imageList
				+ ", sizeList=" + sizeList + "]";
	}

	public GoodsBean() {
		super();
	}

}
