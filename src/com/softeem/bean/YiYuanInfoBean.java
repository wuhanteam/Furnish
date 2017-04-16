package com.softeem.bean;

import java.io.Serializable;

public class YiYuanInfoBean extends GoodsInfoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3699747601277532256L;

	private String yID;
	
	private String ysID;
	
	private String gID;
	
	private String zjID;
	
	private String qgNumber;
	
	private String qgTime;
	
	private String qgsyTime;
	
	private String jqrNumber;
	
	private String isJQRZJ;
	
	private String JQRZJ;
	
	private String isPagetop;
	
	private String recommcolumn;
	
	private String params;

	


	public String getyID() {
		return yID;
	}

	public void setyID(String yID) {
		this.yID = yID;
	}

	public String getYsID() {
		return ysID;
	}

	public void setYsID(String ysID) {
		this.ysID = ysID;
	}

	public String getgID() {
		return gID;
	}

	public void setgID(String gID) {
		this.gID = gID;
	}

	public String getZjID() {
		return zjID;
	}

	public void setZjID(String zjID) {
		this.zjID = zjID;
	}

	public String getQgNumber() {
		return qgNumber;
	}

	public void setQgNumber(String qgNumber) {
		this.qgNumber = qgNumber;
	}

	public String getQgTime() {
		return qgTime;
	}

	public void setQgTime(String qgTime) {
		this.qgTime = qgTime;
	}

	public String getQgsyTime() {
		return qgsyTime;
	}

	public void setQgsyTime(String qgsyTime) {
		this.qgsyTime = qgsyTime;
	}

	public String getJqrNumber() {
		return jqrNumber;
	}

	public void setJqrNumber(String jqrNumber) {
		this.jqrNumber = jqrNumber;
	}

	public String getIsJQRZJ() {
		return isJQRZJ;
	}

	public void setIsJQRZJ(String isJQRZJ) {
		this.isJQRZJ = isJQRZJ;
	}

	public String getJQRZJ() {
		return JQRZJ;
	}

	public void setJQRZJ(String jQRZJ) {
		JQRZJ = jQRZJ;
	}

	public String getIsPagetop() {
		return isPagetop;
	}

	public void setIsPagetop(String isPagetop) {
		this.isPagetop = isPagetop;
	}

	public String getRecommcolumn() {
		return recommcolumn;
	}

	public void setRecommcolumn(String recommcolumn) {
		this.recommcolumn = recommcolumn;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YiYuanInfoBean [yID=");
		builder.append(yID);
		builder.append(", ysID=");
		builder.append(ysID);
		builder.append(", gID=");
		builder.append(gID);
		builder.append(", zjID=");
		builder.append(zjID);
		builder.append(", qgNumber=");
		builder.append(qgNumber);
		builder.append(", qgTime=");
		builder.append(qgTime);
		builder.append(", qgsyTime=");
		builder.append(qgsyTime);
		builder.append(", jqrNumber=");
		builder.append(jqrNumber);
		builder.append(", isJQRZJ=");
		builder.append(isJQRZJ);
		builder.append(", JQRZJ=");
		builder.append(JQRZJ);
		builder.append(", isPagetop=");
		builder.append(isPagetop);
		builder.append(", recommcolumn=");
		builder.append(recommcolumn);
		builder.append(", params=");
		builder.append(params);
		builder.append("]");
		return builder.toString();
	}

	
	
}
