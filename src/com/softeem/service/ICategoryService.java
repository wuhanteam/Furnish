package com.softeem.service;

import java.util.List;

import com.softeem.bean.GoodsBean;
import com.softeem.bean.PageBean;

public interface ICategoryService {
	List<GoodsBean> getGoodsByCate(String cateIdStr);
	
	List<GoodsBean> getGoodsByPageAndCate(String pageNumStr,String pageSizeStr,String cateIdStr);

	// 获取应该显示的页码
    List<Integer> getPageList(String pageNumStr,String pageSizeStr,String cateIdStr);

    
    int getPageCount(String pageSizeStr,String cateIdStr);
    
    /**
     * 获取分页数据: 页面上需要的数据,全部封装到pageBean
     * @param pageNumStr : 页码
     * @param pageSizeStr : 每页的数量
     * @param cateIdStr : cateID
     * @return
     */
    PageBean getPageBean(String pageNumStr,String pageSizeStr,String cateIdStr);
}
