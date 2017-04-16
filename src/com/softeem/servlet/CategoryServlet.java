package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.PageBean;
import com.softeem.service.ICategoryService;

// 分类显示servlet
public class CategoryServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;

	private String pageSizeStr = "2";
	@Autowired
	ICategoryService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		pageSizeStr = config.getInitParameter("page_size");
		super.init(config);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//--------------- <1> 获取cate_id------------------------
		String cateIdStr = request.getParameter("cate_id");
		if(cateIdStr != null){
			// 说明能够拿到cateIdStr
			request.getSession().setAttribute("cate_id", cateIdStr);
		}else{
			cateIdStr = (String) request.getSession().getAttribute("cate_id");
		}
		String pageNumStr = request.getParameter("page_num");
		
		//---------------------------------------------------------

		// --------------- <2> 查询数据------------------------------
		
		PageBean pageBean = service.getPageBean(pageNumStr, pageSizeStr, cateIdStr);
		//-----------------------------------------------------------
		
		// -------------- <3> 存入域对象 ------------------------------
		HttpSession session = request.getSession();
		session.setAttribute("page_bean", pageBean);
		//------------------------------------------------------------

		// <4> 跳转
		response.sendRedirect("category.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
