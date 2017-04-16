package com.softeem.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.softeem.bean.CategoryBean;
import com.softeem.dao.ICategoryDao;
import com.softeem.utils.DataSoureUtils;

@Repository(value="categoryDaoImpl")
public class CategoryDaoImpl implements ICategoryDao {
	private Logger logger = Logger.getLogger(CategoryDaoImpl.class);
	@Resource(name="dataSoureUtils")
	private DataSoureUtils dataSoureUtils;
	
	@Override
	public List<CategoryBean> selectAllCategory() {
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();

		Connection connection = dataSoureUtils.getConnection();

		String sql = "select * from tb_category";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				CategoryBean categoryBean = new CategoryBean();
				categoryBean.setCate_id(resultSet.getInt("cate_id"));
				categoryBean.setCate_name(resultSet.getString("cate_name"));

				// 将category加入到集合中
				categoryList.add(categoryBean);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			dataSoureUtils.close(resultSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return categoryList;
	}

}
