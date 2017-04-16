package com.softeem.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.ResultSetDynaClass;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.softeem.bean.Result;
import com.softeem.dao.IJdbcDAO;
import com.softeem.dao.Page;
import com.softeem.exception.BaseRuntimeException;
import com.softeem.utils.Constants;
import com.softeem.utils.VOResult;

public class JdbcDAOImpl extends JdbcDaoSupport implements IJdbcDAO {
	private int queryTimeout = 30;
	private boolean supportPageing = true;
	private static Logger logger = Logger.getLogger(JdbcDAOImpl.class);

	public List<?> query(String sql, ResultSetExtractor extractor) throws DataAccessException {
		JdbcTemplate jt = getMyJdbcTemplate();
		if (extractor == null) {
			return (List) jt.query(sql, new ListExtractor());
		}

		return (List) jt.query(sql, extractor);
	}

	public List query(String sql, Object[] args, ResultSetExtractor extractor) throws DataAccessException {
		JdbcTemplate jt = getMyJdbcTemplate();
		if (extractor == null) {
			return (List) jt.query(sql, args, new ListExtractor());
		}

		return (List) jt.query(sql, args, extractor);
	}

	public List query(String sql, Object[] args, int[] argTypes, ResultSetExtractor extractor) throws DataAccessException {
		JdbcTemplate jt = getMyJdbcTemplate();
		if (extractor == null) {
			return (List) jt.query(sql, args, new ListExtractor());
		}

		return (List) jt.query(sql, args, argTypes, extractor);
	}

	public List query(String ql, Class clazz, Class extrator) throws DataAccessException {
		if (ql == null) {
			logger.error("查询串为空");
			throw new BaseRuntimeException("查询串为空");
		}

		if ((clazz == null) && (extrator == null)) {
			logger.error("javabean类和行回调接口不能同时为空");
			throw new BaseRuntimeException("javabean类和行回调接口不能同时为空");
		}

		List result = null;

		ResultSetExtractor rse = null;

		if (extrator == null) {
			rse = new DefaultExtrator(clazz);
		} else {
			try {
				rse = (ResultSetExtractor) extrator.newInstance();
			} catch (InstantiationException e) {
				logger.error(extrator.getName() + "类不能实例化", e);
				throw new BaseRuntimeException(extrator.getName() + "类不能实例化", e);
			} catch (IllegalAccessException e) {
				logger.error(extrator.getName() + "类构造方法不允许访问", e);
				throw new BaseRuntimeException(extrator.getName() + "类构造方法不允许访问", e);
			}
		}

		result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(ql), rse);
		return result;
	}

	public List query(String ql, Object[] args, Class clazz, Class extrator) throws DataAccessException {
		if (ql == null) {
			logger.error("查询串为空");
			throw new BaseRuntimeException("查询串为空");
		}

		if ((clazz == null) && (extrator == null)) {
			logger.error("javabean类和行回调接口不能同时为空");
			throw new BaseRuntimeException("javabean类和行回调接口不能同时为空");
		}

		List result = null;

		ResultSetExtractor rse = null;

		if (extrator == null) {
			rse = new DefaultExtrator(clazz);
		} else {
			try {
				rse = (ResultSetExtractor) extrator.newInstance();
			} catch (InstantiationException e) {
				logger.error(extrator.getName() + "类不能实例化", e);
				throw new BaseRuntimeException(extrator.getName() + "类不能实例化", e);
			} catch (IllegalAccessException e) {
				logger.error(extrator.getName() + "类构造方法不允许访问", e);
				throw new BaseRuntimeException(extrator.getName() + "类构造方法不允许访问", e);
			}
		}

		result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(ql), args, rse);
		return result;
	}

	public List query(String ql, Object[] args, int[] argTypes, Class clazz, Class extrator) throws DataAccessException {
		if (ql == null) {
			logger.error("查询串为空");
			throw new BaseRuntimeException("查询串为空");
		}

		if ((clazz == null) && (extrator == null)) {
			logger.error("javabean类和行回调接口不能同时为空");
			throw new BaseRuntimeException("javabean类和行回调接口不能同时为空");
		}

		List result = null;

		ResultSetExtractor rse = null;

		if (extrator == null) {
			rse = new DefaultExtrator(clazz);
		} else {
			try {
				rse = (ResultSetExtractor) extrator.newInstance();
			} catch (InstantiationException e) {
				logger.error(extrator.getName() + "类不能实例化", e);
				throw new BaseRuntimeException(extrator.getName() + "类不能实例化", e);
			} catch (IllegalAccessException e) {
				logger.error(extrator.getName() + "类构造方法不允许访问", e);
				throw new BaseRuntimeException(extrator.getName() + "类构造方法不允许访问", e);
			}
		}

		result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(ql), args, argTypes, rse);
		return result;
	}

	public Object query(String ql, Class clazz) throws DataAccessException {
		List result = query(ql, clazz, null);
		if (result.size() == 0) {
			return null;
		}

		return result.get(0);
	}

	public Object query(String ql, Object[] args, Class clazz) throws DataAccessException {
		List result = query(ql, args, clazz, null);
		if (result.size() == 0) {
			return null;
		}

		return result.get(0);
	}

	public Object query(String ql, Object[] args, int[] argTypes, Class clazz) throws DataAccessException {
		List result = query(ql, args, argTypes, clazz, null);
		if (result.size() == 0) {
			return null;
		}

		return result.get(0);
	}

	private String getCountSql(String sql) {
		String newSql = sql;

		int pos = sql.toLowerCase().lastIndexOf("order by");
		if (pos > 0) {
			newSql = sql.substring(0, pos);
		}
		return " select count(1) from (" + newSql + ") c__";
	}

	private int getBeginPage(int begenPage, int pageSize, int count) {
		if (count == 0) {
			return 1;
		}
		int newCurrentPage = begenPage;
		if ((begenPage > 1) && ((begenPage - 1) * pageSize >= count)) {
			newCurrentPage = (int) Math.ceil(count * 1.0D / pageSize);
		}

		return newCurrentPage;
	}

	private String getPagingSql(String sql, int beginPage, int pageSize) throws DataAccessException {
		if (beginPage * pageSize > Constants.MAX_QUERY_RECORDS) {
			throw new RuntimeException("查询结果中记录数超过允许的最大条数" + Constants.MAX_QUERY_RECORDS + "，请您细化查询条件");
		}
		return "select * from (" + "select q__.*,rownum rn__ from (" + sql + ") q__ where rownum<=" + beginPage * pageSize + ") where rn__> " + pageSize * (beginPage - 1);
	}

	private VOResult newVOResult(List result, int beginPage, int pageSize, int totalNum) {
		VOResult page = new VOResult(result, totalNum);
		page.setBeginPage(beginPage);
		page.setPageSize(pageSize);
		return page;
	}

	private VOResult newVOResult(List result, int beginPage, int pageSize) {
		int endIndex = 0;
		int count = result.size();
		if (beginPage * pageSize >= count) {
			endIndex = count;
		} else {
			endIndex = beginPage * pageSize;
		}

		int newCurrentPage = getBeginPage(beginPage, pageSize, count);
		int beginIndex = (newCurrentPage - 1) * pageSize;
		List page = result.subList((newCurrentPage - 1) * pageSize, endIndex);
		return newVOResult(page, newCurrentPage, pageSize, result.size());
	}

	public VOResult query(String ql, Class clazz, Class extrator, int beginPage, int pageSize) throws DataAccessException {
		if (ql == null) {
			logger.error("查询串为空");
			throw new BaseRuntimeException("查询串为空");
		}

		if ((clazz == null) && (extrator == null)) {
			logger.error("javabean类和行回调接口不能同时为空");
			throw new BaseRuntimeException("javabean类和行回调接口不能同时为空");
		}

		ResultSetExtractor rse = null;

		if (extrator == null) {
			rse = new DefaultExtrator(clazz);
		} else {
			try {
				rse = (ResultSetExtractor) extrator.newInstance();
			} catch (InstantiationException e) {
				logger.error(extrator.getName() + "类不能实例化", e);
				throw new BaseRuntimeException(extrator.getName() + "类不能实例化", e);
			} catch (IllegalAccessException e) {
				logger.error(extrator.getName() + "类构造方法不允许访问", e);
				throw new BaseRuntimeException(extrator.getName() + "类构造方法不允许访问", e);
			}

		}

		if (isSupportPaging()) {
			if (rse == null) {
				rse = new DefaultExtrator(clazz);
			}

			int count = Integer.parseInt(queryForInt(getCountSql(ql), null).toString());
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);

			List result = (List) getMyJdbcTemplate().query(getPagingSql(StringEscapeUtils.unescapeHtml(ql), newCurrentPage, pageSize), rse);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}
		if (rse == null) {
			rse = new DefaultPagingExtrator(clazz);

			int count = Integer.parseInt(queryForInt(getCountSql(ql), null).toString());
			Page p = (Page) rse;
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);
			p.setBeginPage(newCurrentPage);
			p.setPageSize(pageSize);
			p.setRowCount(count);

			List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(ql), rse);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}

		List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(ql), rse);
		return newVOResult(result, beginPage, pageSize);
	}

	public VOResult query(String ql, Object[] args, Class clazz, Class extrator, int beginPage, int pageSize) throws DataAccessException {
		if (ql == null) {
			logger.error("查询串为空");
			throw new BaseRuntimeException("查询串为空");
		}

		if ((clazz == null) && (extrator == null)) {
			logger.error("javabean类和行回调接口不能同时为空");
			throw new BaseRuntimeException("javabean类和行回调接口不能同时为空");
		}

		ResultSetExtractor rse = null;

		if (extrator != null) {
			try {
				rse = (ResultSetExtractor) extrator.newInstance();
			} catch (InstantiationException e) {
				logger.error(extrator.getName() + "类不能实例化", e);
				throw new BaseRuntimeException(extrator.getName() + "类不能实例化", e);
			} catch (IllegalAccessException e) {
				logger.error(extrator.getName() + "类构造方法不允许访问", e);
				throw new BaseRuntimeException(extrator.getName() + "类构造方法不允许访问", e);
			}

		}

		if (isSupportPaging()) {
			if (rse == null) {
				rse = new DefaultExtrator(clazz);
			}
			int count = Integer.parseInt(queryForInt(getCountSql(ql), args).toString());
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);

			List result = (List) getMyJdbcTemplate().query(getPagingSql(StringEscapeUtils.unescapeHtml(ql), newCurrentPage, pageSize), args, rse);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}
		if (rse == null) {
			rse = new DefaultPagingExtrator(clazz);

			int count = Integer.parseInt(queryForInt(getCountSql(ql), args).toString());
			Page p = (Page) rse;
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);
			p.setBeginPage(newCurrentPage);
			p.setPageSize(pageSize);
			p.setRowCount(count);

			List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(ql), args, rse);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}

		List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(ql), args, rse);
		return newVOResult(result, beginPage, pageSize);
	}

	private Object queryForInt(String countSql, Object[] args) {
		return getMyJdbcTemplate().queryForObject(countSql, args, Integer.class);
	}

	public VOResult query(String ql, Object[] args, int[] argTypes, Class clazz, Class extrator, int beginPage, int pageSize) throws DataAccessException {
		if (ql == null) {
			logger.error("查询串为空");
			throw new BaseRuntimeException("查询串为空");
		}

		if ((clazz == null) && (extrator == null)) {
			logger.error("javabean类和行回调接口不能同时为空");
			throw new BaseRuntimeException("javabean类和行回调接口不能同时为空");
		}

		ResultSetExtractor rse = null;

		if (extrator != null) {
			try {
				rse = (ResultSetExtractor) extrator.newInstance();
			} catch (InstantiationException e) {
				logger.error(extrator.getName() + "类不能实例化", e);
				throw new BaseRuntimeException(extrator.getName() + "类不能实例化", e);
			} catch (IllegalAccessException e) {
				logger.error(extrator.getName() + "类构造方法不允许访问", e);
				throw new BaseRuntimeException(extrator.getName() + "类构造方法不允许访问", e);
			}

		}

		if (isSupportPaging()) {
			if (rse == null) {
				rse = new DefaultExtrator(clazz);
			}
			int count = Integer.parseInt(queryForInt(getCountSql(ql), args, argTypes).toString());
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);

			List result = (List) getMyJdbcTemplate().query(getPagingSql(StringEscapeUtils.unescapeHtml(ql), newCurrentPage, pageSize), args, argTypes, rse);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}
		if (rse == null) {
			rse = new DefaultPagingExtrator(clazz);

			int count = Integer.parseInt(queryForInt(getCountSql(ql), args, argTypes).toString());
			Page p = (Page) rse;
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);
			p.setBeginPage(newCurrentPage);
			p.setPageSize(pageSize);
			p.setRowCount(count);

			List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(ql), args, argTypes, rse);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}

		List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(ql), args, argTypes, rse);
		return newVOResult(result, beginPage, pageSize);
	}

	public VOResult query(String sql, ResultSetExtractor extractor, int beginPage, int pageSize) throws DataAccessException {
		JdbcTemplate jt = getMyJdbcTemplate();
		ResultSetExtractor ext = null;
		if (extractor == null) {
			ext = new ListExtractor();
		} else {
			ext = extractor;
		}

		if (isSupportPaging()) {
			if (ext == null) {
				ext = new ListExtractor();
			}

			String countSql = getCountSql(sql);
			int count = Integer.parseInt(queryForInt(countSql, null).toString());
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);

			String pagingSql = getPagingSql(StringEscapeUtils.unescapeHtml(sql), newCurrentPage, pageSize);
			List result = (List) jt.query(pagingSql, ext);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}
		if (ext == null) {
			ext = new ListPagingExtractor();

			int count = Integer.parseInt(queryForInt(getCountSql(sql), null).toString());
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);
			Page p = (Page) ext;
			p.setBeginPage(newCurrentPage);
			p.setPageSize(pageSize);
			p.setRowCount(count);

			List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(sql), ext);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}

		List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(sql), ext);
		return newVOResult(result, beginPage, pageSize);
	}

	public VOResult query(String sql, ResultSetExtractor extractor, Object[] args, int beginPage, int pageSize) throws DataAccessException {
		JdbcTemplate jt = getMyJdbcTemplate();
		ResultSetExtractor ext = null;
		if (extractor != null) {
			ext = extractor;
		}

		if (isSupportPaging()) {
			if (ext == null) {
				ext = new ListExtractor();
			}

			int count = Integer.parseInt(queryForInt(getCountSql(sql), args).toString());
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);

			List result = (List) jt.query(getPagingSql(StringEscapeUtils.unescapeHtml(sql), newCurrentPage, pageSize), args, ext);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}
		if (ext == null) {
			ext = new ListPagingExtractor();

			int count = Integer.parseInt(queryForInt(getCountSql(sql), args).toString());
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);
			Page p = (Page) ext;
			p.setBeginPage(newCurrentPage);
			p.setPageSize(pageSize);
			p.setRowCount(count);

			List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(sql), args, ext);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}

		List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(sql), args, ext);
		return newVOResult(result, beginPage, pageSize);
	}

	public VOResult query(String sql, ResultSetExtractor extractor, Object[] args, int[] argTypes, int beginPage, int pageSize) throws DataAccessException {
		JdbcTemplate jt = getMyJdbcTemplate();
		ResultSetExtractor ext = null;
		if (extractor != null) {
			ext = extractor;
		}

		if (isSupportPaging()) {
			if (ext == null) {
				ext = new ListExtractor();
			}

			int count = Integer.parseInt(queryForInt(getCountSql(sql), args, argTypes).toString());
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);

			List result = (List) jt.query(getPagingSql(StringEscapeUtils.unescapeHtml(sql), newCurrentPage, pageSize), args, argTypes, ext);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}
		if (ext == null) {
			ext = new ListPagingExtractor();

			int count = Integer.parseInt(queryForInt(getCountSql(sql), args, argTypes).toString());
			int newCurrentPage = getBeginPage(beginPage, pageSize, count);
			Page p = (Page) ext;
			p.setBeginPage(newCurrentPage);
			p.setPageSize(pageSize);
			p.setRowCount(count);

			List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(sql), args, argTypes, ext);
			return newVOResult(result, newCurrentPage, pageSize, count);
		}

		List result = (List) getMyJdbcTemplate().query(StringEscapeUtils.unescapeHtml(sql), args, argTypes, ext);
		return newVOResult(result, beginPage, pageSize);
	}

	private Object queryForInt(String countSql, Object[] args, int[] argTypes) {
		getJdbcTemplate().queryForObject(countSql, args, argTypes, Integer.class);
		return null;
	}

	public int executeUpdate(String sql, Object[] params) throws DataAccessException {
		return getMyJdbcTemplate().update(sql, params);
	}

	public int executeUpdate(String sql) throws DataAccessException {
		return getMyJdbcTemplate().update(sql);
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws DataAccessException {
		CallableStatement cs = null;
		try {
			cs = getConnection().prepareCall(sql, resultSetType, resultSetConcurrency);
		} catch (SQLException e) {
			throw getMyJdbcTemplate().getExceptionTranslator().translate("CallableStatement prepareCall(String sql, int resultSetType,int resultSetConcurrency)", sql, e);
		}
		return cs;
	}

	public int getCount(String query) throws DataAccessException {
		String newSql = query;
		int pos = query.toLowerCase().lastIndexOf("order by");
		if (pos > 0)
			newSql = query.substring(0, pos);
		StringBuffer count = new StringBuffer();
		count.append("SELECT COUNT(1) FROM (");
		count.append(newSql);
		count.append(") c__ ");
		return getMyJdbcTemplate().queryForObject(count.toString(), Integer.class);
	}

	public int getCount(String query, Object[] params) throws DataAccessException {
		String newSql = query;
		int pos = query.toLowerCase().lastIndexOf("order by");
		if (pos > 0) {
			newSql = query.substring(0, pos);
		}
		StringBuffer count = new StringBuffer();
		count.append("SELECT COUNT(1) FROM (");
		count.append(newSql);
		count.append(") c__ ");
		return getMyJdbcTemplate().queryForObject(count.toString(), params, Integer.class);
	}

	public boolean isSupportPaging() {
		return this.supportPageing;
	}

	public String getCurrentDbName() {
		return (String) getMyJdbcTemplate().execute(new ConnectionCallback() {
			public Object doInConnection(Connection con) throws SQLException, DataAccessException {
				return con.getMetaData().getDatabaseProductName();
			}
		});
	}

	public JdbcTemplate getMyJdbcTemplate() {
		JdbcTemplate jt = super.getJdbcTemplate();
		jt.setQueryTimeout(this.queryTimeout);
		return jt;
	}

	public int getQueryTimeout() {
		return this.queryTimeout;
	}

	public void setQueryTimeout(int queryTimeout) {
		this.queryTimeout = queryTimeout;
	}

	public boolean isSupportPageing() {
		return this.supportPageing;
	}

	public void setSupportPageing(boolean supportPageing) {
		this.supportPageing = supportPageing;
	}

	private static class DefaultExtrator implements ResultSetExtractor {
		private Class clazz = null;

		public DefaultExtrator(Class clazz) {
			this.clazz = clazz;
		}

		public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List result = new ArrayList();

			ResultSetDynaClass rsdc = new ResultSetDynaClass(resultSet);
			Iterator rows = rsdc.iterator();
			while (rows.hasNext()) {
				DynaBean row = (DynaBean) rows.next();
				Object bean = null;
				try {
					bean = this.clazz.newInstance();
				} catch (InstantiationException e) {
					JdbcDAOImpl.logger.error(this.clazz.getName() + "类不能实例化", e);
					throw new BaseRuntimeException(this.clazz.getName() + "类不能实例化", e);
				} catch (IllegalAccessException e) {
					JdbcDAOImpl.logger.error(this.clazz.getName() + "类构造方法不允许访问", e);
					throw new BaseRuntimeException(this.clazz.getName() + "类构造方法不允许访问", e);
				}
				try {
					BeanUtils.copyProperties(bean, row);
				} catch (Exception e) {
					JdbcDAOImpl.logger.error("克隆属性出错", e);
					throw new BaseRuntimeException("克隆属性出错", e);
				}
				result.add(bean);
			}

			return result;
		}
	}

	private static class DefaultPagingExtrator implements ResultSetExtractor, Page {
		private Class clazz = null;
		private int beginPage;
		private int pageSize;
		private int rowCount;

		public int getBeginPage() {
			return this.beginPage;
		}

		public void setBeginPage(int beginPage) {
			this.beginPage = beginPage;
		}

		public int getPageSize() {
			return this.pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getRowCount() {
			return this.rowCount;
		}

		public void setRowCount(int rowCount) {
			this.rowCount = rowCount;
		}

		public DefaultPagingExtrator(Class clazz) {
			this.clazz = clazz;
		}

		public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List result = new ArrayList();
			int firstRow = (this.beginPage - 1) * this.pageSize + 1;
			if (firstRow > this.rowCount)
				return result;
			if (this.beginPage > 1) {
				if (resultSet.getType() == 1005) {
					resultSet.absolute(firstRow - 1);
				} else {
					for (int m = 0; m < firstRow - 1; m++)
						resultSet.next();
				}
			}
			ResultSetDynaClass rsdc = new ResultSetDynaClass(resultSet);
			int num = 0;
			for (Iterator iter = rsdc.iterator(); (iter.hasNext()) && (num < this.pageSize); num++) {
				DynaBean db = (DynaBean) iter.next();
				Object bean = null;
				try {
					bean = this.clazz.newInstance();
				} catch (InstantiationException e) {
					JdbcDAOImpl.logger.error(this.clazz.getName() + "类不能实例化", e);
					throw new BaseRuntimeException(this.clazz.getName() + "类不能实例化", e);
				} catch (IllegalAccessException e) {
					JdbcDAOImpl.logger.error(this.clazz.getName() + "类构造方法不允许访问", e);
					throw new BaseRuntimeException(this.clazz.getName() + "类构造方法不允许访问", e);
				}
				try {
					BeanUtils.copyProperties(bean, db);
				} catch (Exception e) {
					JdbcDAOImpl.logger.error("克隆属性出错", e);
					throw new BaseRuntimeException("克隆属性出错", e);
				}
				result.add(bean);
			}

			return result;
		}
	}

	public class LimitResultExtractor implements ResultSetExtractor {
		private int totalNum = 0;

		public LimitResultExtractor(int totalNum) {
			this.totalNum = totalNum;
		}

		public Object extractData(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = null;
			Hashtable colNames = null;

			Vector rows = new Vector();
			try {
				metaData = rs.getMetaData();
				int colCount = metaData.getColumnCount();

				String[] columnNames = new String[colCount];

				colNames = new Hashtable(colCount);
				for (int i = 0; i < colCount; i++) {
					columnNames[i] = metaData.getColumnLabel(i + 1).toUpperCase();
					colNames.put(columnNames[i], new Integer(i));
				}

				while (rs.next()) {
					Object[] row = new Object[colCount];
					for (int i = 0; i < colCount; i++) {
						Object obj = rs.getObject(i + 1);
						row[i] = obj;
					}
					rows.addElement(row);
				}
				Object[][] objResult;
				if (rows.size() == 0) {
					objResult = (Object[][]) null;
				} else {
					objResult = new Object[rows.size()][];
					for (int i = 0; i < rows.size(); i++) {
						objResult[i] = ((Object[]) rows.elementAt(i));
					}
				}
				rs.close();
				rs = null;
				return new Result(objResult, this.totalNum, colNames);
			} catch (SQLException e) {
				throw JdbcDAOImpl.this.getMyJdbcTemplate().getExceptionTranslator().translate("getResult(ResultSet rs, int totalNum)", null, e);
			}
		}
	}

	public static class ListExtractor implements ResultSetExtractor {
		public Object extractData(ResultSet rs) throws SQLException {
			ResultSetMetaData md = rs.getMetaData();
			int num = md.getColumnCount();
			List listOfRows = new ArrayList();
			while (rs.next()) {
				Map mapOfColValues = new HashMap(num);
				for (int i = 1; i <= num; i++) {
					mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
				}
				listOfRows.add(mapOfColValues);
			}
			return listOfRows;
		}
	}

	public static class ListPagingExtractor implements ResultSetExtractor, Page {
		private int beginPage;
		private int pageSize;
		private int rowCount;

		public int getBeginPage() {
			return this.beginPage;
		}

		public void setBeginPage(int beginPage) {
			this.beginPage = beginPage;
		}

		public int getPageSize() {
			return this.pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getRowCount() {
			return this.rowCount;
		}

		public void setRowCount(int rowCount) {
			this.rowCount = rowCount;
		}

		public Object extractData(ResultSet rs) throws SQLException {
			ResultSetMetaData md = rs.getMetaData();
			int num = md.getColumnCount();
			List listOfRows = new ArrayList();
			int firstRow = (this.beginPage - 1) * this.pageSize + 1;
			if (firstRow > this.rowCount)
				return listOfRows;
			if (firstRow > 1) {
				if (rs.getType() == 1005) {
					rs.absolute(firstRow - 1);
				} else {
					for (int m = 0; m < firstRow - 1; m++)
						rs.next();
				}
			}
			int currentNum = 0;
			while ((rs.next()) && (currentNum < this.pageSize)) {
				Map mapOfColValues = new HashMap(num);
				for (int i = 1; i <= num; i++) {
					mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
				}
				listOfRows.add(mapOfColValues);
				currentNum++;
			}
			return listOfRows;
		}
	}

	public class UnlimitResultExtractor implements ResultSetExtractor {
		private int totalNum = 0;

		private int beginRow = 0;

		private int rowsOfPage = 0;

		public UnlimitResultExtractor(int totalNum, int beginRow, int rowsOfPage) {
			this.totalNum = totalNum;
			this.beginRow = beginRow;
			this.rowsOfPage = rowsOfPage;
		}

		public Object extractData(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = null;
			Hashtable colNames = null;

			Vector rows = new Vector();

			boolean canScroll = false;
			if (rs.getType() == ResultSet.TYPE_SCROLL_SENSITIVE) {
				canScroll = true;
				if (this.beginRow > this.totalNum) {
					return new Result(null, 0, null);
				}
			}
			metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();

			String[] columnNames = new String[colCount];

			colNames = new Hashtable(colCount);
			for (int i = 0; i < colCount; i++) {
				columnNames[i] = metaData.getColumnLabel(i + 1).toUpperCase();
				colNames.put(columnNames[i], new Integer(i));
			}
			if (!canScroll) {
				int i = 0;
				do {
					i++;
					if (i >= this.beginRow)
						break;
				} while (rs.next());
			} else if (rs.absolute(this.beginRow + 1)) {
				rs.previous();
			}
			for (int count = 1; (count <= this.rowsOfPage) && (rs.next()); count++) {
				Object[] row = new Object[colCount];
				for (int i = 0; i < colCount; i++) {
					Object obj = rs.getObject(i + 1);
					row[i] = obj;
				}
				rows.addElement(row);
			}
			Object[][] objResult;
			if (rows.size() == 0) {
				objResult = (Object[][]) null;
			} else {
				objResult = new Object[rows.size()][];
				for (int i = 0; i < rows.size(); i++) {
					objResult[i] = ((Object[]) rows.elementAt(i));
				}
			}
			rs.close();
			rs = null;
			Result result = new Result(objResult, this.totalNum, colNames);
			return result;
		}
	}

}