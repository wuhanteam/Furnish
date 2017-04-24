package com.softeem.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.service.IAppContentInfoQueryService;

/**
 * Servlet implementation class QueryAppZJInfoByUserServlet
 */
public class QueryAppZJInfoByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	IAppContentInfoQueryService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAppZJInfoByUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		// 查库
		List<Map<String,String>> zjinfolist = service.queryZjInfoByUserID(userId);
		
		JSONObject jobj = new JSONObject();
		jobj.put("zjinfolist", JSONObject.fromObject(zjinfolist).toString());
		
		// 返回前台JSON串
		response.getWriter().write(jobj.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
