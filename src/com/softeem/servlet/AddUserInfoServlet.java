package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.UserInfoBean;
import com.softeem.service.IUserInfoService;
import com.softeem.service.impl.UserInfoServiceImpl;
import com.softeem.utils.DateTimeUtil;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

/**
 * Servlet implementation class AddUserInfoServlet
 */
public class AddUserInfoServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(AddUserInfoServlet.class);

	@Autowired
	IUserInfoService service;
	@Autowired
	HashedCredentialsMatcher  credentialsMatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userCode = request.getParameter("userCode");
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String params = request.getParameter("params");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		logger.info("userCode="+userCode+",userName="+userName+",passwd="+passwd+",params="+params+",mobile="+mobile+",email"+email);
		String algorithmName = credentialsMatcher.getHashAlgorithmName();
		int hashIterations = credentialsMatcher.getHashIterations();
		String salt = new SecureRandomNumberGenerator().nextBytes().toHex();  
		SimpleHash hash = new SimpleHash(algorithmName, passwd,salt, hashIterations);  
	    String encodePasswd = hash.toHex();            
		
		UserInfoBean userInfo = new UserInfoBean();
		userInfo.setUserCode(userCode);
		userInfo.setUserName(userName);
		userInfo.setUserPwd(encodePasswd);
		userInfo.setParams1(params);
		userInfo.setMobile(mobile);
		userInfo.setStatus("1");
		userInfo.setEmail(email);
		userInfo.setSalt(salt);
		userInfo.setCreateTime(DateTimeUtil.getNow());
		
		// 先按用户名查询,看是否有同名用户
		
		UserInfoBean user = service.queryUserInfo(userCode);
		// 
		if(null != user && null != user.getUserName() ){
			// 有重复用户
			response.getWriter().write("2");
			
		}else{
			int result = service.insertUserInfo(userInfo);
			response.getWriter().write(String.valueOf(result));
		}
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
