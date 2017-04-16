package com.softeem.service.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.softeem.bean.YiYuanInfoBean;
import com.softeem.dao.IJdbcDAO;
import com.softeem.dao.IYiYuanInfoDao;
import com.softeem.dao.impl.YiYuanInfoDao;
import com.softeem.service.IYiYuanInfoService;
import com.softeem.utils.VOResult;

@Service("yiYuanInfoServiceImpl")
public class YiYuanInfoServiceImpl implements IYiYuanInfoService {
	@Resource(name = "yiYuanInfoDao")
	private IYiYuanInfoDao dao;
	@Resource(name = "iJdbcDAO")
	private IJdbcDAO jdbcDAO;

	@Override
	public int insertYiYuanInfo(YiYuanInfoBean yiYuanInfo) {
		return dao.insertYiYuanInfo(yiYuanInfo);
	}

	@Override
	public List<YiYuanInfoBean> queryYiYuanInfo() {
		return dao.queryYiYuanInfo();
	}

	@Override
	public YiYuanInfoBean queryYiYuanInfoByID(String gid) {
		return dao.queryYiYuanInfoByID(gid);
	}

	@Override
	public int delYiYuanInfoByIDs(String[] YIDs) {

		return dao.delYiYuanInfoByIDs(YIDs);
	}

	@Override
	public VOResult queryYiYuanInfo(String sql, int beginPage, int pageSize) {

		return jdbcDAO.query(sql, new ResultSetExtractor() {
			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				ResultSetMetaData md = rs.getMetaData();
				int columns = md.getColumnCount();
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				while (rs.next()) {
					Map map = new HashMap<String, Object>();
					;
					for (int i = 1; i <= columns; i++) {
						map.put(md.getColumnName(i), rs.getObject(i));
					}
					list.add(map);
				}
				return list;
			}
		}, beginPage, pageSize);

	}

	@Override
	public int updateBySql(String sql, String[] params) {
		 return jdbcDAO.executeUpdate(sql, params);
		
	}

	@Override
	public YiYuanInfoBean queryYiYuanInfoByYID(String gid) {
		return dao.queryYiYuanInfoByYID(gid);
	}

}
