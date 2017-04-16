package com.softeem.bean;

import java.io.Serializable;

public class CustomerInfoBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -486458833830063494L;
	
	// 客户ID
	private String cid;
	// 客户名称
	private String cusName;
	// 密码
	private String cusPwd;
	//平台名称
	private String ptName;
	// 地址
	private String cusAddress;
	// qq
	private String qq;
	// 支付宝账号
	private String zhfbNum;
	// 电话
	private String phoneNum;
	// 是否机器人
	private String isJQR;
	// 游戏币数量
	private String yxbNum;
	// 备注1
	private String param1;
	// 备注2
	private String param2;
	
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusPwd() {
		return cusPwd;
	}
	public void setCusPwd(String cusPwd) {
		this.cusPwd = cusPwd;
	}
	public String getPtName() {
		return ptName;
	}
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getZhfbNum() {
		return zhfbNum;
	}
	public void setZhfbNum(String zhfbNum) {
		this.zhfbNum = zhfbNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getIsJQR() {
		return isJQR;
	}
	public void setIsJQR(String isJQR) {
		this.isJQR = isJQR;
	}
	public String getYxbNum() {
		return yxbNum;
	}
	public void setYxbNum(String yxbNum) {
		this.yxbNum = yxbNum;
	}
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerInfoBean [cusName=");
		builder.append(cusName);
		builder.append(", cusPwd=");
		builder.append(cusPwd);
		builder.append(", ptName=");
		builder.append(ptName);
		builder.append(", cusAddress=");
		builder.append(cusAddress);
		builder.append(", qq=");
		builder.append(qq);
		builder.append(", zhfbNum=");
		builder.append(zhfbNum);
		builder.append(", pnoneNum=");
		builder.append(phoneNum);
		builder.append(", isJQR=");
		builder.append(isJQR);
		builder.append(", yxbNum=");
		builder.append(yxbNum);
		builder.append(", param1=");
		builder.append(param1);
		builder.append(", param2=");
		builder.append(param2);
		builder.append("]");
		return builder.toString();
	}
	

	
}
