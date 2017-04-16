package com.softeem.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.service.IUserInfoService;
import com.softeem.service.impl.FindPassWordLogServiceImpl;
import com.softeem.utils.Constants;
import com.softeem.utils.DateTimeUtil;
import com.softeem.utils.IDGenerator;
import com.softeem.utils.MD5Util;
import com.softeem.utils.NetInfoUtil;
import com.softeem.utils.SendMailUtil;

public class FindUserPassServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginServlet.class);

	@Autowired
	private IUserInfoService service;
	@Autowired
	private FindPassWordLogServiceImpl findPassWordLogServiceImpl;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String ipAddress = NetInfoUtil.getIpAddr(request);
		String userCode = request.getParameter("userCode");
		String email = request.getParameter("email");
		logger.info(userCode + " 试图找回密码,凭证email " + email + " 登录ip " + ipAddress);
		int count = service.findByUserCodeEmail(userCode, email);
		int logCount = findPassWordLogServiceImpl.findLogSameDay(userCode);
		if (logCount >= Constants.FORGET_PASS_COUNT) {//
			msg = "您填写的资料不匹配,当天失败次数超过" + Constants.FORGET_PASS_COUNT + "次,请联系管理员";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/forgetpassword.jsp").forward(request, response);
			return;
		}
		if (count <1) {
			msg = "您填写的资料不匹配,请联系管理员";
			request.setAttribute("msg", msg);
			// 记录日志
			findPassWordLogServiceImpl.recordLog(userCode, ipAddress, email);
			request.getRequestDispatcher("/forgetpassword.jsp").forward(request, response);
			return;
		} else {
			String key = IDGenerator.generateStrID(Constants.FORGET_SIG_PREFIX);
			String now = DateTimeUtil.getNow();
			// 更新数据库
			int updateflag = service.updateFindPasswd(userCode,key,now);
			
			if(updateflag>0){
				System.out.println(" key>>>" + key);
				String digitalSignature = MD5Util.convertMD5(key);// 数字签名MD5加密
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
				String resetPassHref = basePath + "checkLink?sid=" + digitalSignature + "&userCode=" + userCode;

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("subject", "英雄夺宝系找回密码说明");
				map.put("user", userCode);
				map.put("resetpassUrl","<a href=\"" + resetPassHref+"\""+ " target='_BLANK'\">"+ resetPassHref + "</a>");
				map.put("requestFindHost", ipAddress);
				final String templatePath = "findPasswd.ftl";
				boolean flag = SendMailUtil.sendFtlMail(email, "英雄夺宝系找回密码说明", templatePath, map);
				if (flag) {
					msg = "重置密码邮件已经发送，请登陆邮箱进行重置";
				} else {
					msg = "重置密码邮件发送失败,请检查邮箱是否正确后联系管理员";
				}
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/forgetpassword.jsp").forward(request, response);
				return;
			}else{
				msg = "重置密码邮件发送失败,请联系管理员";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/forgetpassword.jsp").forward(request, response);
				return;
			}
			
		}

	}

}
