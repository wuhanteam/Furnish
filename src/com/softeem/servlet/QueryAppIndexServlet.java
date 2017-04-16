package com.softeem.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.softeem.service.IAppContentInfoQueryService;
import com.softeem.service.impl.AppContentInfoQueryService;

/**
 * Servlet implementation class QueryAppIndexServlet
 */
public class QueryAppIndexServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppContentInfoQueryService service;
 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAppIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * app首页需要返回的东西
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 滚动图片内容 
		List<Map<String,String>> list1 = service.queryPageTopInfo();
		// 查询推荐栏
		List<Map<String,String>> list2 = service.queryRecommColumn();
		// 默认查询按时间查询上架商品信息
		List<Map<String,String>> list3 = service.queryLatestYiyuanInfo();
		
		JSONObject obj = new JSONObject();
		obj.put("pagetop", JSONArray.fromObject(list1));
		obj.put("recommcolumn", JSONArray.fromObject(list2));
		obj.put("latestyiyuanInfo", JSONArray.fromObject(list3));
		System.out.println(obj.toString());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().write(0);
		//JSONArray array = new JSONArray();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
