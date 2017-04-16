package com.softeem.utils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class VOResult implements Serializable {
	private List result = null;
	private Object[] rs = null;

	private int rowNumber = -1;

	private int totalRow = 0;

	private int beginPage = 1;

	private int pageSize = Constants.GLOABAL_PAGESIZE;

	public VOResult() {
	}

	public VOResult(List result) {
		this.result = result;
		if (result != null) {
			this.rowNumber = result.size();
			this.totalRow = result.size();
		}
	}

	public VOResult(List result, int totalRow) {
		this.result = result;
		this.totalRow = totalRow;
		if (result != null)
			this.rowNumber = result.size();
	}

	public Collection getResult() {
		return this.result;
	}

	public Object getObject(int i) {
		if (this.rs == null)
			this.rs = this.result.toArray();
		return this.rs[i];
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getBeginPage() {
		return this.beginPage;
	}

	public int getRowNumber() {
		return this.rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getTotalRow() {
		return this.totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return this.pageSize;
	}
}