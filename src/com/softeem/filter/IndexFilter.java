package com.softeem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class IndexFilter
 */
public class IndexFilter implements Filter {
 
	public void destroy() {
	}

	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 // 判断session是否有数据
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpSession session = request2.getSession();
		//获取session中的数据,如果没有,则需要进入servlet获取
		Object categoryList = session.getAttribute("categoryList");
		Object goodsList = session.getAttribute("goodsList");
		if (categoryList ==null || goodsList == null) {
			// 没有数据: 
			System.out.println("没有数据:跳转到index.do");
			// false : index.do
			request2.getRequestDispatcher("index.do").forward(request, response);
		}else{
			// true : 放行
			chain.doFilter(request, response);
		}
		
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
