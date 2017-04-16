package com.softeem.dao;

import java.sql.CallableStatement;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.softeem.bean.Result;
import com.softeem.utils.VOResult;
import java.sql.CallableStatement;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public abstract interface IJdbcDAO {
	public abstract List query(String paramString, ResultSetExtractor paramResultSetExtractor) throws DataAccessException;

	public abstract List query(String paramString, Object[] paramArrayOfObject, ResultSetExtractor paramResultSetExtractor) throws DataAccessException;

	public abstract List query(String paramString, Object[] paramArrayOfObject, int[] paramArrayOfInt, ResultSetExtractor paramResultSetExtractor) throws DataAccessException;

	public abstract List query(String paramString, Object[] paramArrayOfObject, Class paramClass1, Class paramClass2) throws DataAccessException;

	public abstract List query(String paramString, Object[] paramArrayOfObject, int[] paramArrayOfInt, Class paramClass1, Class paramClass2) throws DataAccessException;

	/*
	 * public abstract Map query(String paramString, Object[]
	 * paramArrayOfObject) throws DataAccessException;
	 */
	/*
	 * public abstract Map query(String paramString, Object[]
	 * paramArrayOfObject, int[] paramArrayOfInt) throws DataAccessException;
	 */

	/*
	 * public abstract Object queryForObject(String paramString, Object[]
	 * paramArrayOfObject) throws DataAccessException;
	 * 
	 * public abstract Object queryForObject(String paramString, Object[]
	 * paramArrayOfObject, int[] paramArrayOfInt) throws DataAccessException;
	 */
	public abstract VOResult query(String paramString, Class paramClass1, Class paramClass2, int paramInt1, int paramInt2) throws DataAccessException;

	public abstract VOResult query(String paramString, Object[] paramArrayOfObject, Class paramClass1, Class paramClass2, int paramInt1, int paramInt2) throws DataAccessException;

	public abstract VOResult query(String paramString, Object[] paramArrayOfObject, int[] paramArrayOfInt, Class paramClass1, Class paramClass2, int paramInt1, int paramInt2) throws DataAccessException;

	public abstract VOResult query(String paramString, ResultSetExtractor paramResultSetExtractor, int paramInt1, int paramInt2) throws DataAccessException;

	public abstract VOResult query(String paramString, ResultSetExtractor paramResultSetExtractor, Object[] paramArrayOfObject, int paramInt1, int paramInt2) throws DataAccessException;

	public abstract VOResult query(String paramString, ResultSetExtractor paramResultSetExtractor, Object[] paramArrayOfObject, int[] paramArrayOfInt, int paramInt1, int paramInt2) throws DataAccessException;

	public abstract List query(String paramString, Class paramClass1, Class paramClass2) throws DataAccessException;

	public abstract Object query(String paramString, Class paramClass) throws DataAccessException;

	public abstract Object query(String paramString, Object[] paramArrayOfObject, Class paramClass) throws DataAccessException;

	public abstract Object query(String paramString, Object[] paramArrayOfObject, int[] paramArrayOfInt, Class paramClass) throws DataAccessException;

	public abstract JdbcTemplate getJdbcTemplate();

	public abstract int executeUpdate(String paramString, Object[] paramArrayOfObject) throws DataAccessException;

	public abstract int executeUpdate(String paramString) throws DataAccessException;

	public abstract int getCount(String paramString) throws DataAccessException;

	public abstract int getCount(String paramString, Object[] paramArrayOfObject) throws DataAccessException;

	public abstract String getCurrentDbName();

}
