package com.softeem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.softeem.service.ICustomerInfoService;
import com.softeem.service.IGoodsService;
import com.softeem.service.IUserInfoService;
import com.softeem.service.IYiYuanInfoService;
import com.softeem.utils.Constants;
import com.softeem.utils.VOResult;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	IUserInfoService userService;

	@Autowired
	ICustomerInfoService customerService;

	@Autowired
	IGoodsService goodService;

	@Autowired
	IYiYuanInfoService yiYuanInfoService;

	public MenuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		request.setAttribute("flag", flag);
		String beginPage = StringUtils.isEmpty(request.getParameter("beginPage"))==true? Constants.BEGIN_PAGE+"":request.getParameter("beginPage") ;
		request.setAttribute("beginPage", beginPage);
		String pageSize = StringUtils.isEmpty(request.getParameter("pageSize"))==true? Constants.GLOABAL_PAGESIZE+"":request.getParameter("pageSize") ;
		request.setAttribute("pageSize", pageSize);
		// 判断菜单标记
		if ("1".equals(flag)) {
			// 用户管理
			String sql = "select t.userid,t.usercode,t.username,t.email,t.mobile,t.params1,t.status,t.last_login_time from t_userinfo t  ";
			VOResult voResult = userService.queryUserInfoList(sql, Integer.parseInt(beginPage), Integer.parseInt(pageSize));
			request.setAttribute("voResult", voResult);
			// 跳转
			request.getRequestDispatcher("/userinfo_list.jsp").forward(request, response);
			return;

		} else if ("2".equals(flag)) {
			// 客户管理
			String sql ="select c.cid,c.uname,c.ptname,c.address,c.qq,c.zfbnum,c.telphone,c.jqrflag,c.params1,c.params2,c.yxbtotalnum from t_customerinfo c";
			VOResult voResult  = customerService.queryAllCustomer(sql,Integer.parseInt(beginPage), Integer.parseInt(pageSize));
			request.setAttribute("voResult", voResult);
			request.getRequestDispatcher("/customer_list.jsp").forward(request, response);
			return;
		} else if ("3".equals(flag)) {
			// 商品信息录入
			String sql = "select * from t_Goods order by gid ";
			VOResult voResult  = goodService.queryAllGoods(sql,Integer.parseInt(beginPage), Integer.parseInt(pageSize));
			request.setAttribute("voResult", voResult);
			request.getRequestDispatcher("/product_list.jsp").forward(request, response);
			return;
		} else if ("4".equals(flag)) {
			// 一元夺宝
			String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,t.GSID from t_goods t,t_yiyuaninfo t1 where t.gid = t1.gid";
			VOResult voResult  = yiYuanInfoService.queryYiYuanInfo(sql,Integer.parseInt(beginPage), Integer.parseInt(pageSize));
			request.setAttribute("voResult", voResult);
			request.getRequestDispatcher("/yiyuanproduct_list.jsp").forward(request, response);
			return;
		}else{
			//暂无对应功能
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
