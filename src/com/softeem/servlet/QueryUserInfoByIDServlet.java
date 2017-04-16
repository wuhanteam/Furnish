package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.UserInfoBean;
import com.softeem.service.IUserInfoService;

/**
 * Servlet implementation class QueryUserInfoByIDServlet
 */
public class QueryUserInfoByIDServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUserInfoService service;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserInfoByIDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("QueryUserInfoById....");
		String userID= request.getParameter("userID");
		UserInfoBean ueseInfo = service.queryUserInfoByID(userID);
		
		if(ueseInfo != null)
		{
			//JSONObject object = new JSONObject();
			JSONObject  obj = JSONObject.fromObject(ueseInfo);
			//object.put("ueseInfo", obj.toString());
			System.out.println(obj.toString());
			response.setContentType("application/json;charset=UTF-8"); 
			response.getWriter().write(obj.toString());
		}
		else{
			
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
