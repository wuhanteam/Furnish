package com.softeem.bean;

import java.io.Serializable;

public class CategoryBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3408461755674208305L;
	private int cate_id;
	private String cate_name;

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public CategoryBean(int cate_id, String cate_name) {
		super();
		this.cate_id = cate_id;
		this.cate_name = cate_name;
	}

	public CategoryBean() {
		super();
	}

	@Override
	public String toString() {
		return "CategoryBean [cate_id=" + cate_id + ", cate_name=" + cate_name
				+ "]";
	}

}
