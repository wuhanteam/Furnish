package com.softeem.bean;

import java.io.Serializable;

public class UserInfoBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -72200633911687258L;

	/**
	 * userID
	 */
	private String userID;

	// 用户名
	private String userCode;

	// 用户名称
	private String userName;

	// 密码
	private String userPwd;

	// 备注
	private String params1;

	private String status;

	private String lastLoginTime;

	private String salt;

	private String ipaddress;

	private String createTime;

	private String validateCode;// 验证码
	
	private String outeDate;// 找回密码失效时间
	
	private String email;// 邮箱地址

	private String mobile;// 手机号
	
	private String spare01;//空闲字段1
	
	private String spare02;//空闲字段2
	
	private String spare03;//空闲字段3
	

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getParams1() {
		return params1;
	}

	public void setParams1(String params1) {
		this.params1 = params1;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getOuteDate() {
		return outeDate;
	}

	public void setOuteDate(String outeDate) {
		this.outeDate = outeDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSpare01() {
		return spare01;
	}

	public void setSpare01(String spare01) {
		this.spare01 = spare01;
	}

	public String getSpare02() {
		return spare02;
	}

	public void setSpare02(String spare02) {
		this.spare02 = spare02;
	}

	public String getSpare03() {
		return spare03;
	}

	public void setSpare03(String spare03) {
		this.spare03 = spare03;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfoBean [userID=");
		builder.append(userID);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", userPwd=");
		builder.append(userPwd);
		builder.append(", params1=");
		builder.append(params1);
		builder.append(",status=").append(status);
		builder.append(",userName=").append(userName);
		builder.append(",mobile=").append(mobile);
		builder.append(",email=").append(email);
		
		builder.append("]");
		return builder.toString();
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
