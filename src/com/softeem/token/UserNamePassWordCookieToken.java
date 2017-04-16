package com.softeem.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserNamePassWordCookieToken extends UsernamePasswordToken {
	private static final long serialVersionUID = 1L;

	private boolean isRemember;// 是否记住密码

	private String loginType;// 0为PC登录，1为手机登录

	public UserNamePassWordCookieToken(String username, char[] password,
			boolean rememberMe, String host, boolean isRemember,
			String loginType) {
		super(username, password, rememberMe, host);
		this.setRemember(isRemember);
		this.loginType = loginType;
	}

	public boolean isRemember() {
		return isRemember;
	}

	public void setRemember(boolean isRemember) {
		this.isRemember = isRemember;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}
