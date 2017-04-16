package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONObject;

import com.softeem.bean.GoodsInfoBean;
import com.softeem.service.IGoodsService;
import com.softeem.service.impl.GoodsServiceImpl;

/**
 * Servlet implementation class QueryGoodsByIDServlet
 */
public class QueryGoodsByIDServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IGoodsService service;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryGoodsByIDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter QueryGoodsByIDServlet ..");
		String gid = request.getParameter("gid");
		String operType = request.getParameter("operType");
		String gsid = request.getParameter("gsid");
        
		response.setCharacterEncoding("UTF-8");
        
		if("checkGsID".equals(operType)){
			int count = service.queryGoodsByGSID(gsid);
			response.setContentType("text/text");
			if(count>0){
				response.getWriter().write("1");
			}else{
				response.getWriter().write("0");
			}
			return ;
		}
		GoodsInfoBean gInfo = service.queryGoodsByID(gid);
		
		if(gInfo!=null){
			//JSONObject object = new JSONObject();
			JSONObject  obj = JSONObject.fromObject(gInfo);
			//object.put("ueseInfo", obj.toString());
			System.out.println(obj.toString());
			response.getWriter().write(obj.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
