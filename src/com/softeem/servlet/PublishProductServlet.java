package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.GoodsInfoBean;
import com.softeem.bean.YiYuanInfoBean;
import com.softeem.service.IGoodsService;
import com.softeem.service.IYiYuanInfoService;

/**
 * Servlet implementation class PublishProductServlet
 */
public class PublishProductServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	IYiYuanInfoService yiyuanService;
	
	@Autowired
	IGoodsService goodService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取gid
		String gid = request.getParameter("gid");
		System.out.println(gid);
		YiYuanInfoBean info = yiyuanService.queryYiYuanInfoByID(gid);
		if(null != info && StringUtils.isNotEmpty(info.getyID())){
			response.getWriter().write("1");
		}else{
			// 通过gid查询商品基本信息
		
			GoodsInfoBean goodsInfo = goodService.queryGoodsByID(gid);
			
			// 入库一元购上架表
			YiYuanInfoBean yiYuanInfo = new YiYuanInfoBean();
			// 商品关联ID
			yiYuanInfo.setgID(goodsInfo.getGid());
			// 分类
			yiYuanInfo.setYsID(goodsInfo.getGsid());
			
			
			int result = yiyuanService.insertYiYuanInfo(yiYuanInfo);
			if(result == 1){
				// 返回成功
				response.getWriter().write("0");
			}else{
				// 返回失败
				response.getWriter().write("-1");
			}
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
