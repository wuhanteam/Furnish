package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.UserInfoBean;
import com.softeem.service.IUserInfoService;
import com.softeem.utils.Constants;
import com.softeem.utils.DateTimeUtil;
import com.softeem.utils.NetInfoUtil;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginServlet.class);

	@Autowired
	private IUserInfoService service;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {// 获取用户名密码
		String userCode = request.getParameter("userCode");
		String pwd = request.getParameter("userPwd");
		String ipAddress = NetInfoUtil.getIpAddr(request);
		boolean rememberMe =  WebUtils.isTrue(request, "rememberMe");
		UsernamePasswordToken token = new UsernamePasswordToken(userCode, pwd,rememberMe);
				
		Subject subject = SecurityUtils.getSubject();

		String errorMsg = "";
		boolean isSuccess = false;
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				logger.info("用户" + subject.getPrincipal() + "登录成功。");
				isSuccess = true;
			}
			
		} catch (IncorrectCredentialsException e) {
			errorMsg = "密码错误,请重新登录!";
			logger.error(e.getMessage());
		} catch (LockedAccountException e) {
			errorMsg = "账户锁定";
			logger.error(e.getMessage());
		} catch (ExcessiveAttemptsException e) {
			errorMsg = "重复次数超过5次,请稍后再试";
			logger.error(e.getMessage());
		} catch (UnknownAccountException e) {
			errorMsg = "用户名不正确";
			logger.error(e.getMessage());
		} catch (AuthenticationException e) {
			errorMsg = "认证失败";
			logger.error(e.getMessage());
		}

		if (isSuccess) {
			service.updateLoginInfo(userCode, ipAddress);
			request.getRequestDispatcher("/index_user.jsp").forward(request,
					response);
		} else {
			request.setAttribute("failreason", errorMsg);
			request.getRequestDispatcher("/index_pc_login.jsp").forward(
					request, response);
		}
	}

}
