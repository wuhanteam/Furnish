package com.softeem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.softeem.bean.CustomerInfoBean;
import com.softeem.dao.ICustomerInfoDao;
import com.softeem.utils.DataSoureUtils;

@Repository(value="customerInfoDaoImpl")
public class CustomerInfoDaoImpl implements ICustomerInfoDao {
	private Logger logger = Logger.getLogger(CustomerInfoDaoImpl.class);
	
	@Resource(name="dataSoureUtils")
	private DataSoureUtils dataSoureUtils;
	
	@Override
	public int addCustomInfo(CustomerInfoBean cusInfo) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		// insert into t_customerinfo(cid, uname, upwd, ptname, address, qq, zfbnum ,telphone, jqrflag, params1,
		//    params2, yxbtotalnum) values (CUSTOMERID_SEQ.Nextval,'yh','123456','ptname','address','qq','zfbnum','11111111111','0','params1','params2',111)
		String sql = "insert into t_customerinfo(cid, uname, upwd, ptname, address, qq, zfbnum ,telphone, jqrflag, params1,params2, yxbtotalnum) "
				+ "values (CUSTOMERID_SEQ.Nextval,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		int result = -1;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, cusInfo.getCusName());
			statement.setString(2, cusInfo.getCusPwd());
			statement.setString(3, cusInfo.getPtName());
			statement.setString(4, cusInfo.getCusAddress());
			statement.setString(5, cusInfo.getQq());
			statement.setString(6, cusInfo.getZhfbNum());
			statement.setString(7, cusInfo.getPhoneNum());
			statement.setString(8, StringUtils.isEmpty(cusInfo.getIsJQR())?"0":cusInfo.getIsJQR());
			statement.setString(9, cusInfo.getParam1());
			statement.setString(10, cusInfo.getParam2());
			statement.setInt(11, Integer.parseInt(cusInfo.getYxbNum()));
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
	public int delCustomerInfo(String[] cusIDs) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "delete from t_customerinfo where cid=?";
		PreparedStatement statement = null;
		int result = -1;
		
		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < cusIDs.length; i++) {
				statement.setString(1, cusIDs[i]);
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
	public int updateCustomerInfo(CustomerInfoBean cusInfo) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		// update t_customerinfo set upwd='123',ptname='1', address='1', qq='1', zfbnum='1' ,telphone='', jqrflag='0', params1='1221',params2='1221', yxbtotalnum=121 where uname='yhh'
		String sql = "update t_customerinfo "
				+ "set upwd=?,ptname=?, address=?, qq=?, zfbnum=? ,telphone=?, jqrflag=?, params1=?,params2=?, yxbtotalnum=? "
				+ "where uname=?";
		PreparedStatement statement = null;
		int result = -1;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, cusInfo.getCusPwd());
			statement.setString(2, cusInfo.getPtName());
			statement.setString(3, cusInfo.getCusAddress());
			statement.setString(4, cusInfo.getQq());
			statement.setString(5, cusInfo.getZhfbNum());
			statement.setString(6, cusInfo.getPhoneNum());
			statement.setString(7, cusInfo.getIsJQR());
			statement.setString(8, cusInfo.getParam1());
			statement.setString(9, cusInfo.getParam2());
			statement.setString(10, cusInfo.getYxbNum());
			statement.setString(11, cusInfo.getCusName());
			statement.executeUpdate();
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
	public CustomerInfoBean queryCustomerByID(String cusID) {
		
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select * from t_customerinfo where cid=?";
		PreparedStatement statement = null;
		ResultSet resulrSet = null;
		CustomerInfoBean info = new CustomerInfoBean();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, cusID);
			resulrSet = statement.executeQuery();
			while(resulrSet.next()){
				info.setCusName(resulrSet.getString("uname"));
				info.setCusPwd(resulrSet.getString("upwd"));
				info.setPtName(resulrSet.getString("ptname"));
				
				info.setCusAddress(resulrSet.getString("address"));
				info.setQq(resulrSet.getString("qq"));
				info.setZhfbNum(resulrSet.getString("zfbnum"));
				info.setPhoneNum(resulrSet.getString("telphone"));
				info.setIsJQR(resulrSet.getString("jqrflag"));
				info.setYxbNum(resulrSet.getString("yxbtotalnum"));
				info.setParam1(resulrSet.getString("params1"));
				info.setParam2(resulrSet.getString("params2"));
				
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}finally{
			dataSoureUtils.close(resulrSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}
		
		return info;
		
	}

	@Override
	public CustomerInfoBean queryCustomerByName(String cusName) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select cid,uname,upwd from t_customerinfo where uname=?";
		PreparedStatement statement = null;
		ResultSet resulrSet = null;
		
		CustomerInfoBean info = new CustomerInfoBean();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, cusName);
			resulrSet = statement.executeQuery();
			while(resulrSet.next()){
				info.setCusName(resulrSet.getString("uname"));
				info.setCid(resulrSet.getString("cid"));
				
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}finally{
			dataSoureUtils.close(resulrSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}
		
		return info;
	}

	@Override
	public List<CustomerInfoBean> queryAllCustomer() {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select * from t_customerinfo order by cid";
		PreparedStatement statement = null;
		ResultSet resulrSet = null;
		List<CustomerInfoBean> list = new ArrayList<CustomerInfoBean>();
		try {
			statement = connection.prepareStatement(sql);
			resulrSet = statement.executeQuery();
			while(resulrSet.next()){
				CustomerInfoBean info = new CustomerInfoBean();
				info.setCusName(resulrSet.getString("uname"));
				info.setCid(resulrSet.getString("cid"));
				info.setCusAddress(resulrSet.getString("address"));
				info.setPtName(resulrSet.getString("ptname"));
				info.setQq(resulrSet.getString("qq"));
				info.setPhoneNum(resulrSet.getString("telphone"));
				info.setZhfbNum(resulrSet.getString("zfbnum"));
				info.setIsJQR(resulrSet.getString("jqrflag"));
				info.setParam1(resulrSet.getString("params1"));
				info.setParam2(resulrSet.getString("params2"));
				info.setYxbNum(resulrSet.getString("yxbtotalnum"));
				
				list.add(info);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}finally{
			dataSoureUtils.close(resulrSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}
		
		return list;
	}

}
