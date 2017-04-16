package com.softeem.dao;

import java.util.List;

import com.softeem.bean.YiYuanInfoBean;

public interface IYiYuanInfoDao {
	
	public int insertYiYuanInfo(YiYuanInfoBean yiYuanInfo);
	
	public List<YiYuanInfoBean> queryYiYuanInfo();
	
	public YiYuanInfoBean queryYiYuanInfoByID(String gid);
	
	public int delYiYuanInfoByIDs(String[] YIDs);

	YiYuanInfoBean queryYiYuanInfoByYID(String yid);

}
