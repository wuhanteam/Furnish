package com.softeem.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.softeem.datasource.IDataSource;

@Component("dataSoureUtils")
public class DataSoureUtils {
	private static Logger logger = Logger.getLogger(DataSoureUtils.class);

	@Resource(name = "customerDataSource")
	private  IDataSource dataSource;

	public  Connection getConnection() {
		return dataSource.getConnection();
	}

	public  void close(Connection conn) {
		dataSource.closeConnection(conn);
	}

	public  void close(ResultSet rs) {
		dataSource.closeResultSet(rs);
	}

	public  void close(Statement statement) {
		dataSource.closeStatement(statement);
	}
	

}
