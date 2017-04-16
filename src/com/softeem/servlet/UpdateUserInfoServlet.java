package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.UserInfoBean;
import com.softeem.service.IUserInfoService;
import com.softeem.service.impl.UserInfoServiceImpl;
import com.softeem.utils.StringUtils;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
public class UpdateUserInfoServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	IUserInfoService service;
	@Autowired
	HashedCredentialsMatcher  credentialsMatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter UpdateUserInfoServlet..");
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String oldUserPwd = request.getParameter("oldUserPwd");
		String params = request.getParameter("params");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String status = request.getParameter("status");
		
		UserInfoBean userInfo = new UserInfoBean();
		userInfo.setUserID(userID);
		userInfo.setUserName(userName);
		UserInfoBean dataBaseUserInfo = service.queryUserInfoByID(userID);
		
		userInfo.setStatus(status);
		
		//不修改密码和私钥
		if(!StringUtils.isEmpty(passwd) && oldUserPwd.equals(passwd))
		{
		  userInfo.setUserPwd(passwd);
		  userInfo.setSalt(dataBaseUserInfo.getSalt());
		}else{//修改了密码
			String algorithmName = credentialsMatcher.getHashAlgorithmName();
			int hashIterations = credentialsMatcher.getHashIterations();
			String salt = new SecureRandomNumberGenerator().nextBytes().toHex();  
			SimpleHash hash = new SimpleHash(algorithmName, passwd,salt, hashIterations);  
		    String encodePasswd = hash.toHex(); 
		    userInfo.setUserPwd(encodePasswd);
		    userInfo.setSalt(salt);
		}	
		userInfo.setParams1(params);
		userInfo.setMobile(mobile);
		userInfo.setEmail(email);
		int result = service.updateUserInfo(userInfo);
		if(result == 0){
			// 修改成功返回0
			response.getWriter().write("0");
		}else{
			// 失败返回-1
			response.getWriter().write("-1");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
