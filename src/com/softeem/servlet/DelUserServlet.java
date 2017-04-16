package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.service.IUserInfoService;
import com.softeem.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class DelUserServlet
 */
public class DelUserServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	IUserInfoService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter DelUserServlet..");
		String params = request.getParameter("params");
		String [] userIDs = params.split(",");
		
	
		
		// 删除
		int result = service.delUserInfoByID(userIDs);
		
		if(result==0)
		{
			// 删除成功返回0 
			response.getWriter().write("0");
			
		}
		else
		{
			// 删除成功返回0 
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
