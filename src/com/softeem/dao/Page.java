package com.softeem.dao;

public abstract interface Page {
	public abstract int getBeginPage();

	public abstract void setBeginPage(int paramInt);

	public abstract int getPageSize();

	public abstract void setPageSize(int paramInt);

	public abstract int getRowCount();

	public abstract void setRowCount(int paramInt);
}
