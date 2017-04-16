package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.service.ICustomerInfoService;
import com.softeem.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class DelCustomerServlet
 */
public class DelCustomerServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	ICustomerInfoService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter DelCustomerServlet..");
		String params = request.getParameter("params");
		String[] cusIDs = params.split(",");
		
		
		int result = service.delCustomerInfo(cusIDs);
		
		if(result == 0){
			//返回成功
			response.getWriter().write("0");
		}else{
			// 返回失败
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
