package com.softeem.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.service.IYiYuanInfoService;
import com.softeem.service.impl.YiYuanInfoServiceImpl;

/**
 * Servlet implementation class DelYiyuanInfoServlet
 */
public class MofifyYiyuanInfoServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	IYiYuanInfoService service;

	public MofifyYiyuanInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	{"gid":gid,"qgrs":qgrs,"qgsj":qgsj,"Jqr":Jqr,"sysj":sysj
	    	"param":param,"isJqr":isJqr,"iszd":iszd,"istj":istj}
		*/
		String yid = request.getParameter("gid");
		String qgsj = request.getParameter("qgsj");//抢购时间
		String sysj = request.getParameter("sysj");//抢购剩余时间
		String qgrs = request.getParameter("qgrs");//抢购人数
		String Jqr = request.getParameter("Jqr");//机器人数
		String isJqr = request.getParameter("isJqr");//是否机器人中奖
		String iszd = request.getParameter("iszd");//是否指定
		String istj = request.getParameter("istj");//是否推荐
		String param = request.getParameter("param");//备注
		String sql =" update t_yiyuaninfo t set t.qgtime=?,t.qgsytime=?,t.qgnumber=?,"
				+ "t.jqrnumber=?,t.isjqrzj=?,t.ispagetop=?,t.recommcolumn=?,t.params=? where t.yid=?";
		int flag = service.updateBySql(sql,new String[]{qgsj,sysj,qgrs,Jqr,isJqr,iszd,istj,param,yid});
		if(flag>0){
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
