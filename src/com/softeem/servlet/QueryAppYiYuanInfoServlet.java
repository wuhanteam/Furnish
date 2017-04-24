package com.softeem.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.service.IAppContentInfoQueryService;

/**
 * Servlet implementation class QueryAppYiYuanInfoServlet
 */
public class QueryAppYiYuanInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	IAppContentInfoQueryService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAppYiYuanInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 根据ID查询商品详细信息
		String yid = request.getParameter("yid");
		Map<String,String> detailInfo = service.queryOneYiyuanInfo(yid);
		
		JSONObject jobj = new JSONObject();
		jobj.put("detailInfo", JSONObject.fromObject(detailInfo).toString());
		
		// 返回前台
		response.getWriter().write(jobj.toString());
				
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
