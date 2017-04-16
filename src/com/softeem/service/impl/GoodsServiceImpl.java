package com.softeem.service.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.softeem.bean.GoodsInfoBean;
import com.softeem.dao.IGoodsInfoDao;
import com.softeem.dao.IJdbcDAO;
import com.softeem.dao.impl.GoodsInfoDaoImpl;
import com.softeem.service.IGoodsService;
import com.softeem.utils.VOResult;

@Service("goodsServiceImpl")
public class GoodsServiceImpl implements IGoodsService {
	@Resource(name = "goodsInfoDaoImpl")
	private IGoodsInfoDao dao;
	@Resource(name = "iJdbcDAO")
	private IJdbcDAO jdbcDAO;
	
	@Override
	public int addGoodsInfo(GoodsInfoBean info) {

		return dao.addGoodsInfo(info);
	}

	@Override
	public int delGoodsByID(String[] gIDs) {
		return dao.delGoodsByID(gIDs);
	}

	@Override
	public int updateGoodsInfo(GoodsInfoBean info) {

		return dao.updateGoodsInfo(info);
	}

	@Override
	public GoodsInfoBean queryGoodsByID(String gID) {
		return dao.queryGoodsByID(gID);
	}

	@Override
	public List<GoodsInfoBean> queryAllGoods() {
		return dao.queryAllGoods();
	}

	@Override
	public VOResult queryAllGoods(String sql, int beginPage, int pageSize) {
		
		return jdbcDAO.query(sql, new ResultSetExtractor() {
			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				ResultSetMetaData md = rs.getMetaData();
				int columns = md.getColumnCount();
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				while (rs.next()) {
					Map map = new HashMap<String, Object>();;
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
	public int queryGoodsByGSID(String gsid) {
		String sql = "select * from t_Goods t where t.gid = ?";
		return jdbcDAO.getCount(sql,new String[]{gsid});
	}

}
