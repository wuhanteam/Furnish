package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.GoodsInfoBean;
import com.softeem.service.IGoodsService;
import com.softeem.service.impl.GoodsServiceImpl;

/**
 * Servlet implementation class UpdateGoodsInfoServlet
 */
public class UpdateGoodsInfoServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	IGoodsService service;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGoodsInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter UpdateGoodsInfoServlet..");
		
		String gid = request.getParameter("gid");
		String gsid = request.getParameter("gsid");
    	String gName = request.getParameter("gName");
    	String gDate = request.getParameter("gDate");
    	String gDetail = request.getParameter("gDetail");
    	String  isExpire = request.getParameter("isExpire");
    	String gPrice = request.getParameter("gPrice");
    	String gIMG1 = request.getParameter("gIMG1");
    	String gIMG2 = request.getParameter("gIMG2");
    	String gIMG3 = request.getParameter("gIMG3");
    	String gNumber = request.getParameter("gNumber");
    	String gSYNumber = request.getParameter("gSYNumber");	
	    
    	GoodsInfoBean goodsInfo = new GoodsInfoBean();
    	goodsInfo.setGid(gid);
    	goodsInfo.setGsid(gsid);
    	goodsInfo.setgName(gName);
    	goodsInfo.setgDate(gDate);
    	goodsInfo.setIsExpire(isExpire);
    	goodsInfo.setgDetail(gDetail);
    	goodsInfo.setgPrice(gPrice);
    	goodsInfo.setgIMG1(gIMG1);
    	goodsInfo.setgIMG2(gIMG2);
    	goodsInfo.setgIMG3(gIMG3);
    	goodsInfo.setgNumber(gNumber);
    	goodsInfo.setgSYNumber(gSYNumber);
    	
    	int result = service.updateGoodsInfo(goodsInfo);
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
