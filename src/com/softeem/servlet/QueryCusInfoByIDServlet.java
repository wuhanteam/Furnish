package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONObject;

import com.softeem.bean.CustomerInfoBean;
import com.softeem.service.ICustomerInfoService;
import com.softeem.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class QueryCusInfoByIDServlet
 */
public class QueryCusInfoByIDServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	ICustomerInfoService service ;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCusInfoByIDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter QueryCusInfoByIDServlet .. ");
		String cusID= request.getParameter("cusID");
		CustomerInfoBean cusInfo = service.queryCustomerByID(cusID);
		
		if(cusInfo != null)
		{
			//JSONObject object = new JSONObject();
			JSONObject  obj = JSONObject.fromObject(cusInfo);
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
