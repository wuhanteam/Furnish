package com.softeem.bean;

import java.io.Serializable;

public class GoodsInfoBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6229989910292191149L;
	
	private String gid;
	
	private String gsid;
	
	private String gName;
	
	private String gDate;
	
	private String gIMG1;
	
	private String gIMG2;
	
	private String gIMG3;
	
	private String gDetail;
	
	private String isExpire;
	
	private String gPrice;
	// 期号
	private String gNumber;
	// 购买剩余
	private String gSYNumber;
	
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGsid() {
		return gsid;
	}
	public void setGsid(String gsid) {
		this.gsid = gsid;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgDate() {
		return gDate;
	}
	public void setgDate(String gDate) {
		this.gDate = gDate;
	}
	public String getgIMG1() {
		return gIMG1;
	}
	public void setgIMG1(String gIMG1) {
		this.gIMG1 = gIMG1;
	}
	public String getgIMG2() {
		return gIMG2;
	}
	public void setgIMG2(String gIMG2) {
		this.gIMG2 = gIMG2;
	}
	public String getgIMG3() {
		return gIMG3;
	}
	public void setgIMG3(String gIMG3) {
		this.gIMG3 = gIMG3;
	}
	public String getgDetail() {
		return gDetail;
	}
	public void setgDetail(String gDetail) {
		this.gDetail = gDetail;
	}
	public String getIsExpire() {
		return isExpire;
	}
	public void setIsExpire(String isExpire) {
		this.isExpire = isExpire;
	}
	public String getgPrice() {
		return gPrice;
	}
	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}
	public String getgNumber() {
		return gNumber;
	}
	public void setgNumber(String gNumber) {
		this.gNumber = gNumber;
	}
	public String getgSYNumber() {
		return gSYNumber;
	}
	public void setgSYNumber(String gSYNumber) {
		this.gSYNumber = gSYNumber;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsInfoBean [gid=");
		builder.append(gid);
		builder.append(", gsid=");
		builder.append(gsid);
		builder.append(", gName=");
		builder.append(gName);
		builder.append(", gDate=");
		builder.append(gDate);
		builder.append(", gIMG1=");
		builder.append(gIMG1);
		builder.append(", gIMG2=");
		builder.append(gIMG2);
		builder.append(", gIMG3=");
		builder.append(gIMG3);
		builder.append(", gDetail=");
		builder.append(gDetail);
		builder.append(", isExpire=");
		builder.append(isExpire);
		builder.append(", gPrice=");
		builder.append(gPrice);
		builder.append(", gNumber=");
		builder.append(gNumber);
		builder.append(", gSYNumber=");
		builder.append(gSYNumber);
		builder.append("]");
		return builder.toString();
	}

	
	
}
