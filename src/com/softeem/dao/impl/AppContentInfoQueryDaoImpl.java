package com.softeem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.softeem.dao.IAppContentInfoQueryDao;
import com.softeem.utils.DataSoureUtils;

@Repository(value="appContentInfoQueryDaoImpl")
public class AppContentInfoQueryDaoImpl implements IAppContentInfoQueryDao {
	private Logger logger = Logger.getLogger(AppContentInfoQueryDaoImpl.class);
	
	@Resource(name="dataSoureUtils")
	private DataSoureUtils dataSoureUtils;
	@Override
	public List<Map<String, String>> queryRecommColumn() {

		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}finally{
			dataSoureUtils.close(resultSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return list;
	}

	@Override
	public List<Map<String, String>> queryPageTopInfo() {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

	@Override
	public List<Map<String, String>> queryLatestYiyuanInfo() {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

	@Override
	public List<Map<String, String>> queryFastestYiyuanInfo() {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

	@Override
	public List<Map<String, String>> queryHottestYiyuanInfo() {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

	@Override
	public List<Map<String, String>> queryYiyuanInfoByPriceDesc() {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

	@Override
	public List<Map<String, String>> queryYiyuanInfoByPriceAsc() {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

	@Override
	public List<Map<String, String>> queryZjInfolist() {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

	@Override
	public Map<String, String> queryOneYiyuanInfo(String yid) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		// List<Map<String, String>> list = new ArrayList<Map<String,String>>();

		Map<String, String> map = new HashMap<String, String>();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				// list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new HashMap<String, String>();
		}

		return map;
	}

	@Override
	public List<Map<String, String>> queryZjInfoByUserID(String userID) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

	@Override
	public List<Map<String, String>> queryRechargeRecordInfo(String userID) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

	@Override
	public Map<String, String> queryCustomerInfo(String cid) {
		// 获取数据库连接
				Connection connection = dataSoureUtils.getConnection();
				String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
						+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
				PreparedStatement statement = null;
				ResultSet resultSet = null;
				// List<Map<String, String>> list = new ArrayList<Map<String,String>>();

				Map<String, String> map = new HashMap<String, String>();
				try {
					statement = connection.prepareStatement(sql);
					resultSet = statement.executeQuery();

					while (resultSet.next()) {
						map.put("YID", resultSet.getString("YID"));
						map.put("YSID", resultSet.getString("YSID"));
						map.put("GID", resultSet.getString("GID"));
						map.put("ZJID", resultSet.getString("ZJID"));
						map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
						map.put("QGTIME", resultSet.getString("QGTIME"));
						map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
						map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
						map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
						map.put("JQRZJ", resultSet.getString("JQRZJ"));
						map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
						map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
						map.put("PARAMS", resultSet.getString("PARAMS"));
						map.put("GNAME", resultSet.getString("GNAME"));
						map.put("GPRICE", resultSet.getString("GPRICE"));
						map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
						map.put("GSID", resultSet.getString("GSID"));
						map.put("GDETAIL", resultSet.getString("GDETAIL"));
						map.put("GIMG", resultSet.getString("GIMG"));
						map.put("GIMG2", resultSet.getString("GIMG2"));
						map.put("GIMG3", resultSet.getString("GIMG3"));
						// list.add(map);
					}
				} catch (SQLException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
					return new HashMap<String, String>();
				}

				return map;
	}

	@Override
	public List<Map<String, String>> queryShoppingCartInfo(String cid) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,T.GSID,t.gdetail,t.GIMG,t.GIMG2,t.GIMG3 from t_goods t,t_yiyuaninfo t1 "
				+ "	where t.gid = t1.gid and t.isexpire='0' and t1.ispagetop='0' and t1.recommcolumn='1'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("YID", resultSet.getString("YID"));
				map.put("YSID", resultSet.getString("YSID"));
				map.put("GID", resultSet.getString("GID"));
				map.put("ZJID", resultSet.getString("ZJID"));
				map.put("QGNUMBER", resultSet.getString("QGNUMBER"));
				map.put("QGTIME", resultSet.getString("QGTIME"));
				map.put("QGSYTIME", resultSet.getString("QGSYTIME"));
				map.put("JQRNUMBER", resultSet.getString("JQRNUMBER"));
				map.put("ISJQRZJ", resultSet.getString("ISJQRZJ"));
				map.put("JQRZJ", resultSet.getString("JQRZJ"));
				map.put("ISPAGETOP", resultSet.getString("ISPAGETOP"));
				map.put("RECOMMCOLUMN", resultSet.getString("RECOMMCOLUMN"));
				map.put("PARAMS", resultSet.getString("PARAMS"));
				map.put("GNAME", resultSet.getString("GNAME"));
				map.put("GPRICE", resultSet.getString("GPRICE"));
				map.put("GSYNUMBER", resultSet.getString("GSYNUMBER"));
				map.put("GSID", resultSet.getString("GSID"));
				map.put("GDETAIL", resultSet.getString("GDETAIL"));
				map.put("GIMG", resultSet.getString("GIMG"));
				map.put("GIMG2", resultSet.getString("GIMG2"));
				map.put("GIMG3", resultSet.getString("GIMG3"));
				list.add(map);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}

		return list;
	}

}
