package com.softeem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToMenuIndex
 */
public class ToMenuIndex extends AutowiredHttpServlet {
       
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3833310914146207090L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		//根据用户名称查询用户权限 菜单名称
		
		// 将菜单 用户信息返回前台
		
		// 跳转登录页面
		request.getRequestDispatcher(request.getContextPath()+"/index_user.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
