package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.GoodsBean;
import com.softeem.service.ISingleService;
import com.softeem.service.impl.SingleServiceImpl;

// single.do
public class SingleServlet extends AutowiredHttpServlet {
	
	@Autowired
	ISingleService service;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取到商品id
		String goodsIdStr = request.getParameter("goods_id");
		
		// 调用service
		GoodsBean goodsBean = service.getSingleGoods(goodsIdStr);
		
		// 存入域对象
		request.getSession().setAttribute("single_goods", goodsBean);
		
		// 跳转页面
		response.sendRedirect("single.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
