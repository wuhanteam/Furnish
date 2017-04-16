package com.softeem.datasource.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;
import com.softeem.datasource.IDataSource;

/**
 * @author Ye
 *
 */
@Component("customerDataSource")
public class CustomerDataSource implements IDataSource {
	public Logger logger = Logger.getLogger(DruidDataSource.class);

	@Resource(name = "dataSource")
	private DruidDataSource datasource;

	@Override
	public Connection getConnection() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}

	}

	@Override
	public void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}

	}

}
