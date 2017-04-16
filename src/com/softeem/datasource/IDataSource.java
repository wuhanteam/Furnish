package com.softeem.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public interface IDataSource {

	public Connection getConnection();

	public void closeConnection(Connection conn);

	public void closeResultSet(ResultSet rs);

	public void closeStatement(Statement st);
}