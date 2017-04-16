package com.softeem.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeem.bean.GoodsInfoBean;
import com.softeem.service.IGoodsService;
import com.softeem.utils.UploadUtils;

/**
 * Servlet implementation class AddGoodsInfoServlet
 */
public class AddGoodsInfoServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	IGoodsService service;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enter AddGoodsInfoServlet..");
		String gsid = request.getParameter("gsid");
    	String gName = request.getParameter("gName");
    	String gDate = request.getParameter("gDate");
    	String gDetail = request.getParameter("gDetail");
    	String  isExpire = request.getParameter("isExpire");
    	String gPrice = request.getParameter("gPrice");
    	/*String addgIMG1 = request.getParameter("addgIMG1");
    	String addgIMG2 = request.getParameter("addgIMG2");
    	String addgIMG3 = request.getParameter("addgIMG3");*/
    	String gNumber = request.getParameter("gNumber");
    	String gSYNumber = request.getParameter("gSYNumber");
    	
    	UploadUtils util = new UploadUtils();
    	List<HashMap<String,String>> uploadInfoList = util.uploadFile(request);
    	//验证文件域返回错误信息 info[1] 上传文件错误信息 info[2] savePath info[3] saveUrl info[4] fileUrl
    	StringBuffer sb = new StringBuffer();
    	String gIMG1="";
    	String gIMG2="";
    	String gIMG3="";
    	for(HashMap<String,String> map: uploadInfoList){
    		String error = map.get("error");
    		String FieldName = map.get("FieldName");
    		String savePath = map.get("savePath");
    		String fileUrl = map.get("fileUrl");
    		String saveUrl = map.get("saveUrl");
    		if("true".equals(error)){
    			if("addgIMG1".equals(FieldName)){
    				gIMG1 = fileUrl;
    			}
    			if("addgIMG2".equals(FieldName)){
    				gIMG2 = fileUrl;
    			}
    			if("addgIMG3".equals(FieldName)){
    				gIMG3 = fileUrl;
    			}
    		}else{
    			sb.append(FieldName).append(error);
    		}
    	}
    	
    		GoodsInfoBean goodsInfo = new GoodsInfoBean();
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
        	
        	int result = service.addGoodsInfo(goodsInfo);
         StringBuffer msg = new StringBuffer();
    	if(result==0){
    		msg.append("数据添加成功");
    	}else{
    		msg.append("数据添加失败");
    	}
    	msg.append(sb.toString());
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(msg.toString());
	}

}
