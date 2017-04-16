package com.softeem.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.softeem.bean.UserInfoBean;
import com.softeem.service.IUserInfoService;

public class CustomerRealm extends AuthorizingRealm {

	@Resource(name = "userInfoServiceImpl")
	private IUserInfoService iUserInfoService;

	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) {

		String userCode = (String) authcToken.getPrincipal();
		UserInfoBean user = iUserInfoService.queryUserInfo(userCode);
		if (user == null) {
			throw new UnknownAccountException();
		}
		if (!"1".equals(user.getStatus())) {
			throw new LockedAccountException();
		}
		String saltStr = user.getSalt();
		ByteSource salt = ByteSource.Util.bytes(saltStr);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user.getUserCode(), user.getUserPwd(), salt, getName());
		return info;

	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String userCode = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// authorizationInfo.setRoles(iUserInfoService.findRoles(userCode));
		// authorizationInfo.setStringPermissions(iUserInfoService.findPermissions(userCode));

		return authorizationInfo;
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
