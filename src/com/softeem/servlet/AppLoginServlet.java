package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.CustomerInfoBean;
import com.softeem.bean.UserInfoBean;
import com.softeem.dao.ILoginDao;

/**
 * Servlet implementation class AppLoginServlet
 */
public class AppLoginServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	ILoginDao service;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户名密码
		String username = request.getParameter("userName");
		String pwd = request.getParameter("userPwd");
		
		// 查询数据库
		// UserInfoBean user = service.queryUserInfo(username);
		CustomerInfoBean cInfo = service.queryCustomInfo(username);
		
		if(pwd.equals(cInfo.getCusPwd())){
			// 跳转菜单页面
			System.out.println("跳转");
			// response.getWriter().write("0");
//			request.setAttribute("userName",username ); 
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/index_user.jsp");
//			dispatcher.forward(request, response);
			response.getWriter().write("0");
			
		}else{
			// 返回失败参数
			System.out.println("返回失败");
			response.getWriter().write("-1");
			// response.setContentType("application/json;charset=UTF-8");
//			JSONObject obj = new JSONObject();
//			obj.put("result", "1");
//			 JSONArray jsonArray = new JSONArray();  
//		        jsonArray.add(obj);  
//		        System.out.println("返回串"+jsonArray.toString());
			// response.getWriter().write("1111");
			// request.setAttribute("failreason", "请输入正确的用户名和密码！");
			
			// response.sendRedirect("index_pc_login.jsp");
			// RequestDispatcher dispatcher = request.getRequestDispatcher("/index_pc_login.jsp");
			// dispatcher.forward(request, response);		
			}
		
		System.out.println(username+"/"+pwd);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
