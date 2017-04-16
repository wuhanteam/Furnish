package com.softeem.service;

import java.util.List;

import com.softeem.bean.YiYuanInfoBean;
import com.softeem.utils.VOResult;

public interface IYiYuanInfoService {

	public int insertYiYuanInfo(YiYuanInfoBean yiYuanInfo);
	
	public List<YiYuanInfoBean> queryYiYuanInfo();
	
	public YiYuanInfoBean queryYiYuanInfoByID(String gid);
	
	public YiYuanInfoBean queryYiYuanInfoByYID(String gid);
	
	public int delYiYuanInfoByIDs(String[] YIDs);

	public VOResult queryYiYuanInfo(String sql, int beginPage, int pageSize);

	public int updateBySql(String sql, String[] param);


}

