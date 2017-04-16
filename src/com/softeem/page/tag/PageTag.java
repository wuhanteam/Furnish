package com.softeem.page.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.softeem.utils.Constants;

/**
 * @author Ye
 *
 */
public class PageTag extends TagSupport {
	private static final long serialVersionUID = 4640134319504221211L;

	private static final Logger logger = Logger.getLogger(PageTag.class);

	private String form;

	private String parameters;

	private String showPages;

	private String rows;

	private String pageSize;

	private String curPage;

	private String totalPages;
	
	private String colSpan;

	private String PREVIOUS_PAGE = "上一页";

	private String NEXT_PAGE = "下一页 ";
	private StringBuffer strBuf;

	public String getHref(int number) {
		return "Javascript:ToPage(" + number + ");";
	}

	public String goHref(int number) {
		return " <li> <a href=\"" + getHref(number) + "\">" + number + "</a></li>";
	}
	
	public PageTag(){
		this.curPage = "1";
	    this.pageSize = Constants.GLOABAL_PAGESIZE+"";
	    this.rows = "0";
	    //this.showPages = "0";
	    strBuf = new StringBuffer();
	}
	
	
	public int doEndTag() throws JspException {
		
		String contextPath = ((HttpServletRequest)this.pageContext.getRequest()).getContextPath();
		int showPages = Integer.parseInt(this.showPages);
		int curPage = Integer.parseInt(this.curPage);
		int pageSize = Integer.parseInt(this.pageSize);
		int rows = Integer.parseInt(this.rows);
		int totalPages = (int)Math.ceil((double)rows / pageSize);
		
		if (curPage == 0) {  
			curPage = 1;  
        } else {  
            if (curPage <= 0) {  
            	curPage = 1;  
            }  
            if (curPage > totalPages) {  
            	curPage = totalPages;  
            }  
        }  
		
		StringBuffer strBuf = new StringBuffer();

		strBuf.append("<style type='text/css'>");
		strBuf.append(".page { width: 50%;float: right;}");
		strBuf.append(".page li a{display: block;text-decoration: none;color: #666666;}");
		strBuf.append(".page li.go_page:hover{background:none;}");
		strBuf.append("</style>");

		strBuf.append("<script language='JavaScript' type='text/JavaScript'>");
		strBuf.append("function ToPage(p) { \n");
		strBuf.append(" window.document." + form + ".beginPage.value=p;\n");
		strBuf.append(" window.document." + form + ".submit();\n");
		strBuf.append("}</script>");
		strBuf.append("<tr>\r\n");
		strBuf.append("<td colspan=\""+colSpan+"\" align=\"right\">");
		strBuf.append("<ul class=\"page\">");
		strBuf.append("<li style=\"border:0;\">共"+rows+"条记录,"+curPage+"/"+totalPages+"页</li>");
		
		if (curPage > 1) {  
            strBuf.append("<li> <a href=\"" + getHref(curPage - 1) + "\"  >" + PREVIOUS_PAGE + "</a></li>");  
        }  
		
		// 分页
		if (totalPages <= showPages + 2) {
			for (int i = 1; i <= totalPages; i++) {
				if (i == curPage) {
					strBuf.append("<li class=\"active\"> <a href=\"" + getHref(i) + "\">" + i + "</a></li>");
				} else {
					strBuf.append(goHref(i));
				}
			}
		} else {
			if (curPage < showPages) {
				for (int i = 1; i <= showPages; i++) {
					if (i == curPage) {
						strBuf.append("<li class=\"active\"> <a href=\"" + getHref(i) + "\">" + i + "</a></li>");
					} else {
						strBuf.append(goHref(i));
					}
				}
				strBuf.append("<li><a> ... </a></li>");
				strBuf.append(goHref(totalPages));
			} else if (curPage > totalPages - showPages + 1) { // 右边
				strBuf.append(goHref(1));
				for (int i = totalPages - showPages + 1; i <= totalPages; i++) {
					if (i == curPage) {
						strBuf.append("<li class=\"active\"> <a href=\"" + getHref(i) + "\">" + i + "</a></li>");
					} else {
						strBuf.append(goHref(i));
					}
				}
			} else { // 中间
				strBuf.append(goHref(1));
				// strBuf.append(goHref(2));
				int offset = (showPages - 2) / 2;
				for (int i = curPage - offset; i <= curPage + offset; i++) {
					if (i == curPage) {
						strBuf.append("<li class=\"active\"> <a href=\"" + getHref(i) + "\">" + i + "</a></li>");
					} else {
						strBuf.append(goHref(i));
					}
				}
				strBuf.append("<li><a> ... </a></li>");
				strBuf.append(goHref(totalPages));
			}
		}

		// 显示下-页
		if (curPage != totalPages) {
			strBuf.append("<li> <a href=\"" + getHref(curPage + 1) + "\" >" + NEXT_PAGE + "</a></li>");
		}

		//strBuf.append("<input name='pageNo' type='hidden' size='3' length='3' />");
		strBuf.append("</ul>");
		strBuf.append("</td>");
		strBuf.append("</tr>");
		try {
			pageContext.getOut().println(strBuf.toString());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return EVAL_PAGE;
	}
	

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getShowPages() {
		return showPages;
	}

	public void setShowPages(String showPages) {
		this.showPages = showPages;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public String getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

	public String getPREVIOUS_PAGE() {
		return PREVIOUS_PAGE;
	}

	public void setPREVIOUS_PAGE(String pREVIOUS_PAGE) {
		PREVIOUS_PAGE = pREVIOUS_PAGE;
	}

	public String getNEXT_PAGE() {
		return NEXT_PAGE;
	}

	public void setNEXT_PAGE(String nEXT_PAGE) {
		NEXT_PAGE = nEXT_PAGE;
	}

	public String getColSpan() {
		return colSpan;
	}

	public void setColSpan(String colSpan) {
		this.colSpan = colSpan;
	}

	

}
