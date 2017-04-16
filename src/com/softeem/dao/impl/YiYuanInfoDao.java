package com.softeem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.softeem.bean.YiYuanInfoBean;
import com.softeem.dao.IYiYuanInfoDao;
import com.softeem.utils.DataSoureUtils;
import com.softeem.utils.IDGenerator;

@Repository(value="yiYuanInfoDao")
public class YiYuanInfoDao implements IYiYuanInfoDao {

	private Logger logger = Logger.getLogger(YiYuanInfoDao.class);
	
	@Resource(name="dataSoureUtils")
	private DataSoureUtils dataSoureUtils;
	
	@Override
	public int insertYiYuanInfo(YiYuanInfoBean yiYuanInfo) {

		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "insert into t_yiyuaninfo (YID,YSID,GID) values (?,? ,?)";
		PreparedStatement statement = null;
		int result = -1;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, IDGenerator.generateStrID("yiyuan"));
			statement.setString(2, yiYuanInfo.getYsID());
			statement.setString(3, yiYuanInfo.getgID());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return result;
		} finally {
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return result;
	}

	@Override
	public List<YiYuanInfoBean> queryYiYuanInfo() {

		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select t1.*,t.GNAME,t.GPRICE,t.GSYNUMBER,t.GSID from t_goods t,t_yiyuaninfo t1 where t.gid = t1.gid";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<YiYuanInfoBean> list = new ArrayList<YiYuanInfoBean>();

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				YiYuanInfoBean yiyuanInfo = new YiYuanInfoBean();
				yiyuanInfo.setgID(resultSet.getString("GID"));
				yiyuanInfo.setyID(resultSet.getString("YID"));
				yiyuanInfo.setYsID(resultSet.getString("YSID"));
				// 分类ID
				yiyuanInfo.setGsid(resultSet.getString("GSID"));
				// 商品名称
				yiyuanInfo.setgName(resultSet.getString("GNAME"));
				// 商品价格
				yiyuanInfo.setgPrice(resultSet.getString("GPRICE"));
				// 购买剩余
				yiyuanInfo.setgSYNumber(resultSet.getString("GSYNUMBER"));
				// 抢购人数
				yiyuanInfo.setQgNumber(resultSet.getString("QGNUMBER"));
				// 中奖ID
				yiyuanInfo.setZjID(resultSet.getString("ZJID"));
				// 抢购时间
				yiyuanInfo.setQgTime(resultSet.getString("QGTIME"));
				// 抢购剩余时间
				yiyuanInfo.setQgsyTime(resultSet.getString("QGSYTIME"));
				// 机器人数量
				yiyuanInfo.setJqrNumber(resultSet.getString("JQRNUMBER"));
				// 机器人中奖
				yiyuanInfo.setJQRZJ(resultSet.getString("jQRZJ"));
				// 机器人是否参与中奖
				yiyuanInfo.setIsJQRZJ(resultSet.getString("ISJQRZJ"));
				// 是否页面置顶
				yiyuanInfo.setIsPagetop(resultSet.getString("ISPAGETOP"));
				// 是否展示推荐栏
				yiyuanInfo.setRecommcolumn(resultSet.getString("RECOMMCOLUMN"));
				// 备注
				yiyuanInfo.setParams(resultSet.getString("PARAMS"));

				list.add(yiyuanInfo);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return new ArrayList<YiYuanInfoBean>();
		}

		return list;
	}

	@Override
	public YiYuanInfoBean queryYiYuanInfoByYID(String yid) {

		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		

		String sql = "select t.YID,t.YSID,t.GID,t.ZJID,t.QGNUMBER,t.QGTIME,t.QGSYTIME,t.JQRNUMBER,t.ISJQRZJ,t.JQRZJ,t.ISPAGETOP,t.RECOMMCOLUMN,t.PARAMS from t_yiyuaninfo t where t.yid=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		YiYuanInfoBean yiyuanInfo = new YiYuanInfoBean();

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, yid);
			resultSet = statement.executeQuery();

			// 查询
			while (resultSet.next()) {
				yiyuanInfo.setyID(resultSet.getString("YID"));
				yiyuanInfo.setYsID(resultSet.getString("YSID"));
				yiyuanInfo.setgID(resultSet.getString("GID"));
				yiyuanInfo.setZjID(resultSet.getString("ZJID"));
				yiyuanInfo.setQgNumber(resultSet.getString("QGNUMBER"));
				yiyuanInfo.setQgTime(resultSet.getString("QGTIME"));
				yiyuanInfo.setQgsyTime(resultSet.getString("QGSYTIME"));
				yiyuanInfo.setJqrNumber(resultSet.getString("JQRNUMBER"));
				yiyuanInfo.setZjID(resultSet.getString("ISJQRZJ"));
				yiyuanInfo.setJQRZJ(resultSet.getString("JQRZJ"));
				yiyuanInfo.setIsPagetop(resultSet.getString("ISPAGETOP"));
				yiyuanInfo.setRecommcolumn(resultSet.getString("RECOMMCOLUMN"));
				yiyuanInfo.setParams(resultSet.getString("PARAMS"));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}

		return yiyuanInfo;
	}
	
	@Override
	public YiYuanInfoBean queryYiYuanInfoByID(String gid) {

		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		

		String sql = "select t.YID,t.YSID,t.GID,t.ZJID,t.QGNUMBER,t.QGTIME,t.QGSYTIME,t.JQRNUMBER,t.ISJQRZJ,t.JQRZJ,t.ISPAGETOP,t.RECOMMCOLUMN,t.PARAMS from t_yiyuaninfo t where t.gid=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		YiYuanInfoBean yiyuanInfo = new YiYuanInfoBean();

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, gid);
			resultSet = statement.executeQuery();

			// 查询
			while (resultSet.next()) {
				yiyuanInfo.setyID(resultSet.getString("YID"));
				yiyuanInfo.setYsID(resultSet.getString("YSID"));
				yiyuanInfo.setgID(resultSet.getString("GID"));
				yiyuanInfo.setZjID(resultSet.getString("ZJID"));
				yiyuanInfo.setQgNumber(resultSet.getString("QGNUMBER"));
				yiyuanInfo.setQgTime(resultSet.getString("QGTIME"));
				yiyuanInfo.setQgsyTime(resultSet.getString("QGSYTIME"));
				yiyuanInfo.setJqrNumber(resultSet.getString("JQRNUMBER"));
				yiyuanInfo.setZjID(resultSet.getString("ISJQRZJ"));
				yiyuanInfo.setJQRZJ(resultSet.getString("JQRZJ"));
				yiyuanInfo.setIsPagetop(resultSet.getString("ISPAGETOP"));
				yiyuanInfo.setRecommcolumn(resultSet.getString("RECOMMCOLUMN"));
				yiyuanInfo.setParams(resultSet.getString("PARAMS"));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}

		return yiyuanInfo;
	}

	@Override
	public int delYiYuanInfoByIDs(String[] YIDs) {
		// TODO
		// 获取连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "";
		PreparedStatement statement = null;
		int result = -1;

		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < YIDs.length; i++) {
				statement.setString(1, YIDs[i]);
				statement.addBatch();
			}
			statement.executeBatch();
			connection.commit();
			result = 0;

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return result;
		} finally {

			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return result;
	}

}
