package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.service.IYiYuanInfoService;
import com.softeem.service.impl.YiYuanInfoServiceImpl;

/**
 * Servlet implementation class DelYiyuanInfoServlet
 */
public class DelYiyuanInfoServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	IYiYuanInfoService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelYiyuanInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String params = request.getParameter("params");
		System.out.println(params);
		String[] YIDs = params.split(",");
		
		int result = service.delYiYuanInfoByIDs(YIDs);
		
		if(result == 0){
			response.getWriter().write("0");
		}else{
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
