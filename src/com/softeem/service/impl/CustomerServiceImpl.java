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

import com.softeem.bean.CustomerInfoBean;
import com.softeem.dao.ICustomerInfoDao;
import com.softeem.dao.IJdbcDAO;
import com.softeem.service.ICustomerInfoService;
import com.softeem.utils.VOResult;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements ICustomerInfoService {
	@Resource(name = "customerInfoDaoImpl")
	private ICustomerInfoDao dao;
	
	@Resource(name = "iJdbcDAO")
	private IJdbcDAO jdbcDAO;

	@Override
	public int addCustomInfo(CustomerInfoBean cusInfo) {
		return dao.addCustomInfo(cusInfo);
	}

	@Override
	public int delCustomerInfo(String[] cusIDs) {
		return dao.delCustomerInfo(cusIDs);
	}

	@Override
	public int updateCustomerInfo(CustomerInfoBean cusInfo) {
		return dao.updateCustomerInfo(cusInfo);
	}

	@Override
	public CustomerInfoBean queryCustomerByID(String cusID) {
		return dao.queryCustomerByID(cusID);
	}

	@Override
	public CustomerInfoBean queryCustomerByName(String cusName) {
		return dao.queryCustomerByName(cusName);
	}

	@Override
	public List<CustomerInfoBean> queryAllCustomer() {
		return dao.queryAllCustomer();
	}

	@Override
	public VOResult queryAllCustomer(String sql, int beginPage, int pageSize) {
		
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

}
