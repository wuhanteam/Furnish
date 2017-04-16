
package com.softeem.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.GoodsBean;
import com.softeem.service.ICategoryService;
import com.softeem.service.impl.CategoryServiceImpl;

// 封装之前的备份
public class CategoryServletBackup extends AutowiredHttpServlet {
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
		// --------------- <1> 获取cate_id------------------------
		String cateIdStr = request.getParameter("cate_id");
		if (cateIdStr != null) {
			// 说明能够拿到cateIdStr
			request.getSession().setAttribute("cate_id", cateIdStr);
		} else {
			cateIdStr = (String) request.getSession().getAttribute("cate_id");
		}
		String pageNumStr = request.getParameter("page_num");

		// ---------------------------------------------------------

		// --------------- <2> 查询数据------------------------------
		
		// 查询当前页的商品数据
		List<GoodsBean> goodsList = service.getGoodsByPageAndCate(pageNumStr,
				pageSizeStr, cateIdStr);

		// 查询页码数据:
		List<Integer> pageList = service.getPageList(pageNumStr, pageSizeStr,
				cateIdStr);
		// 获取总页数:
		int pageCount = service.getPageCount(pageSizeStr, cateIdStr);

		// -----------------------------------------------------------

		// -------------- <3> 存入域对象 ------------------------------
		HttpSession session = request.getSession();
		session.setAttribute("cate_goods_list", goodsList);
		session.setAttribute("cate_page_list", pageList);
		session.setAttribute("last_page_num", pageCount);
		session.setAttribute("current_page",
				CategoryServiceImpl.parseInt(pageNumStr, 1));
		// ------------------------------------------------------------

		// <4> 跳转
		response.sendRedirect("category.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
