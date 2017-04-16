package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.CustomerInfoBean;
import com.softeem.service.ICustomerInfoService;
import com.softeem.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class AddCustomerInfoServlet
 */
public class AddCustomerInfoServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private CustomerServiceImpl service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// String cusID = request.getParameter("cusID");
		String cusName = request.getParameter("cusName");
		String cusPwd = request.getParameter("cusPwd");
		String ptName = request.getParameter("ptName");
		String cusAddress = request.getParameter("cusAddress");
		String qq = request.getParameter("qq");
		String zhfbNum = request.getParameter("zhfbNum");
		String phoneNum = request.getParameter("phoneNum");
		String isJQR = request.getParameter("isJQR");
		String yxbNum = request.getParameter("yxbNum");
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		
		//构造bean对象
		CustomerInfoBean cusInfo = new CustomerInfoBean();
		cusInfo.setCusName(cusName);
		cusInfo.setCusPwd(cusPwd);
		cusInfo.setPtName(ptName);
		cusInfo.setCusAddress(cusAddress);
		cusInfo.setQq(qq);
		cusInfo.setZhfbNum(zhfbNum);
		cusInfo.setPhoneNum(phoneNum);
		cusInfo.setIsJQR(isJQR);
		cusInfo.setYxbNum(yxbNum);
		cusInfo.setParam1(param1);
		cusInfo.setParam2(param2);
		
		CustomerInfoBean customer = service.queryCustomerByName(cusName);
		if(customer != null && customer.getCusName()!=null){
			// 返回2 有重复用户名
			response.getWriter().write("2");
		}else{
			int result = service.addCustomInfo(cusInfo);
			
			if(result == 0){
				// 返回成功
				response.getWriter().write("0");
			}else{
				// 返回失败
				response.getWriter().write("-1");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
