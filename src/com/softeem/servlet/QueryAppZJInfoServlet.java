package com.softeem.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.service.IAppContentInfoQueryService;

/**
 * Servlet implementation class QueryAppZJInfoServlet
 */
public class QueryAppZJInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	IAppContentInfoQueryService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAppZJInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 查询中奖信息的list
		List<Map<String,String>> zjInfoList = service.queryZjInfolist();
		JSONObject obj = new JSONObject();
		obj.put("zjinfolist", JSONArray.fromObject(zjInfoList));
		// 返回JSON串，前台解析
		response.getWriter().write(obj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
