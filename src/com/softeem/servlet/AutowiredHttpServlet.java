package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class AutowiredHttpServlet extends HttpServlet {
	private static final long serialVersionUID = -2000909174467653847L;

	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		AutowireCapableBeanFactory factory = ctx.getAutowireCapableBeanFactory();
		factory.autowireBean(this);
	}

	/**
	 * 直接输出json。
	 */
	public void renderJson(HttpServletResponse response, String json) {
		response(response, json, "application/json;charset=UTF-8");
	}

	/**
	 * 直接输出纯HTML。
	 */
	public void renderHtml(HttpServletResponse response, String text) {
		response(response, text, "text/html;charset=UTF-8");
	}

	/**
	 * 直接输出纯字符串。
	 */
	public void renderText(HttpServletResponse response, String text) {
		response(response, text, "text/plain;charset=UTF-8");
	}

	public void response(HttpServletResponse response, String text, String contentType) {
		try {
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {

		}
	}

}
