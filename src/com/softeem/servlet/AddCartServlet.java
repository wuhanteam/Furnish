package com.softeem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCartServlet
 */
public class AddCartServlet extends AutowiredHttpServlet  {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String goodsId = request.getParameter("goods_id");
		String sizeInfo = request.getParameter("size");
		String count = request.getParameter("count");
		System.out.println(goodsId);
		System.out.println(sizeInfo);
		System.out.println(count);
		
		//TODO 插入数据库
		
		//跳转到checkout.jsp
		response.sendRedirect("checkout.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
