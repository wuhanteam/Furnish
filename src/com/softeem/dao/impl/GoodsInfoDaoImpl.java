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

import com.softeem.bean.GoodsInfoBean;
import com.softeem.dao.IGoodsInfoDao;
import com.softeem.utils.DataSoureUtils;
import com.softeem.utils.IDGenerator;

@Repository(value="goodsInfoDaoImpl")
public class GoodsInfoDaoImpl implements IGoodsInfoDao {
	private Logger logger = Logger.getLogger(GoodsDaoImpl.class);
	
	@Resource(name="dataSoureUtils")
	private DataSoureUtils dataSoureUtils;
	
	@Override
	public int addGoodsInfo(GoodsInfoBean info) {
		Connection connection = dataSoureUtils.getConnection();
		String sql = "insert into t_Goods (gid,gsid,gname,gdate,gimg1,gdetail,isexpire,gprice,gimg2,gimg3,gnumber,gsynumber) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		int result = -1;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, IDGenerator.generateStrID("G"));
			statement.setString(2, info.getGsid());
			statement.setString(3, info.getgName());
			statement.setString(4, info.getgDate());
			statement.setString(5, info.getgIMG1());
			statement.setString(6, info.getgDetail());
			statement.setString(7, info.getIsExpire());
			statement.setString(8, info.getgPrice());
			statement.setString(9, info.getgIMG2());
			statement.setString(10, info.getgIMG3());
			statement.setString(11, info.getgNumber());
			statement.setString(12, info.getgSYNumber());
			
			statement.execute();
			connection.commit();
			result = 0;
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return result;
		}finally{
			
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}
		
		
		return result;
	}

	@Override
	public int delGoodsByID(String[] gIDs) {
		Connection connection = dataSoureUtils.getConnection();
		String sql = "delete from t_Goods where gid=?";
		PreparedStatement statement = null;
		int result = -1;
		
		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < gIDs.length; i++) {
				statement.setString(1, gIDs[i]);
				statement.addBatch();
			}
			statement.executeBatch();
			connection.commit();
			result = 0;
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return result;
		}finally{
			
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}
		
		return result;
	}

	@Override
	public int updateGoodsInfo(GoodsInfoBean info) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "update t_Goods set gsid=?, gdate=?,gimg=?,gdetail=?,isexpire=?,gprice=?,gimg2=?,gimg3=?,gnumber=?,gsynumber=? where gsid=?";
		PreparedStatement statement = null;
		int result = -1;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, info.getGsid());
			statement.setString(2, info.getgDate());
			statement.setString(3, info.getgIMG1());
			statement.setString(4, info.getgDetail());
			statement.setString(5, info.getIsExpire());
			statement.setString(6, info.getgPrice());
			statement.setString(7, info.getgIMG2());
			statement.setString(8, info.getgIMG3());
			statement.setString(9, info.getgNumber());
			statement.setString(10, info.getgSYNumber());
			statement.setString(11, info.getGid());
			
			statement.executeUpdate();
			connection.commit();
			result = 0;
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return result;
		}
		
		return result;
	}

	@Override
	public GoodsInfoBean queryGoodsByID(String gID) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql ="select * from t_Goods where gid=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		GoodsInfoBean gInfo = new GoodsInfoBean();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, gID);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				
				gInfo.setGid(resultSet.getString("gid"));
				gInfo.setGsid(resultSet.getString("gsid"));
				gInfo.setgName(resultSet.getString("gName"));
				gInfo.setgDate(resultSet.getString("gDate"));
				gInfo.setIsExpire(resultSet.getString("isExpire"));
				gInfo.setgDetail(resultSet.getString("gDetail"));
				gInfo.setgPrice(resultSet.getString("gPrice"));
				gInfo.setgIMG1(resultSet.getString("gIMG1"));
				gInfo.setgIMG2(resultSet.getString("gIMG2"));
				gInfo.setgIMG3(resultSet.getString("gIMG3"));
				gInfo.setgNumber(resultSet.getString("gNumber"));
				gInfo.setgSYNumber(resultSet.getString("gSYNumber"));
				
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
		return gInfo;
	}

	@Override
	public List<GoodsInfoBean> queryAllGoods() {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql ="select * from t_Goods order by gid";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<GoodsInfoBean> list = new ArrayList<GoodsInfoBean>();
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				GoodsInfoBean gInfo = new GoodsInfoBean();
				gInfo.setGid(resultSet.getString("gid"));
				gInfo.setGsid(resultSet.getString("gsid"));
				gInfo.setgName(resultSet.getString("gName"));
				gInfo.setgDate(resultSet.getString("gDate"));
				gInfo.setIsExpire(resultSet.getString("isExpire"));
				gInfo.setgDetail(resultSet.getString("gDetail"));
				gInfo.setgPrice(resultSet.getString("gPrice"));
				gInfo.setgIMG1(resultSet.getString("gIMG"));
				gInfo.setgIMG2(resultSet.getString("gIMG2"));
				gInfo.setgIMG3(resultSet.getString("gIMG3"));
				gInfo.setgNumber(resultSet.getString("gNumber"));
				gInfo.setgSYNumber(resultSet.getString("gSYNumber"));
				list.add(gInfo);
			}
			
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}finally{
			dataSoureUtils.close(resultSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}
		
		
		return list;
	}

}
