package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.YiYuanInfoBean;
import com.softeem.service.IYiYuanInfoService;

/**
 * Servlet implementation class DelYiyuanInfoServlet
 */
public class QueryYiyuanInfoServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	IYiYuanInfoService service;
    public QueryYiyuanInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String yyinfoId = request.getParameter("yyinfoId");
		YiYuanInfoBean yiYuanInfoBean = service.queryYiYuanInfoByYID(yyinfoId);
		response.setCharacterEncoding("UTF-8");
		if(yiYuanInfoBean!=null){
			JSONObject json = JSONObject.fromObject(yiYuanInfoBean);
			response.getWriter().write(json.toString());
		}else{
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
