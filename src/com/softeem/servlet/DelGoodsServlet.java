package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.dao.IGoodsInfoDao;
import com.softeem.dao.impl.GoodsInfoDaoImpl;
import com.softeem.service.IGoodsService;
import com.softeem.service.impl.GoodsServiceImpl;

/**
 * Servlet implementation class DelGoodsServlet
 */
public class DelGoodsServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	IGoodsService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter DelGoodsServlet ..");
		String params = request.getParameter("params");
		String[] gIDs = params.split(",");
		
		
		int result = service.delGoodsByID(gIDs);
		
		if(result == 0){
			response.getWriter().write("0");
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
