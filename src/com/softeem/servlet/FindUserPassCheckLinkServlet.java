package com.softeem.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.UserInfoBean;
import com.softeem.service.IUserInfoService;
import com.softeem.utils.DateTimeUtil;
import com.softeem.utils.DateUtils;
import com.softeem.utils.MD5Util;

public class FindUserPassCheckLinkServlet extends AutowiredHttpServlet {
	@Autowired
	private IUserInfoService service;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1680797371166789373L;
	private Logger logger = Logger.getLogger(LoginServlet.class);


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("sid");
		String userCode = req.getParameter("userCode");
		logger.info("sid>>>" + sid);

		if (sid.equals("") || userCode.equals("")) {
			req.setAttribute("msg", "链接不完整,请重新生成");
			logger.info(">>>>> null");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
		UserInfoBean userbeab = service.queryUserInfo(userCode);
		if(userbeab==null || userbeab.getUserID()==null){
			req.setAttribute("msg", "链接错误,无法找到匹配用户,请重新申请找回密码.");
			logger.info("用户不存在"+userCode);
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}else{
			String outDate = userbeab.getOuteDate();
			Date outDateTime = DateUtils.parseDate(outDate);
			long hour = DateUtils.CalHour(outDateTime, new Date());
			if (hour<=0) { // 表示已经过期
				req.setAttribute("msg", "链接已经过期,请重新申请找回密码.");
				logger.info("时间 超时"+userCode + "失效时间:"+outDate+",当前时间:"+DateTimeUtil.getNow());
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}else{//没有过期
				//解析密钥
				String key = MD5Util.convertMD5(sid);
				String validateCode = userbeab.getValidateCode();
				if(validateCode!=null && validateCode.equals(key)){
					 //链接验证通过 转到修改密码页面
	                req.setAttribute("user", userbeab);
	                req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
				}else{
					req.setAttribute("msg", "密钥不匹配,请重新申请找回密码.");
					System.out.println("密钥和服务器不匹配");
					req.getRequestDispatcher("error.jsp").forward(req, resp);
				}
				
			}
			
		}
		
		
	}

}
