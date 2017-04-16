package com.softeem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.softeem.bean.GoodsBean;
import com.softeem.dao.IGoodsDao;
import com.softeem.utils.DataSoureUtils;

@Repository(value="goodsDaoImpl")
public class GoodsDaoImpl implements IGoodsDao {
	private Logger logger = Logger.getLogger(GoodsDaoImpl.class);
	@Resource(name="dataSoureUtils")
	private DataSoureUtils dataSoureUtils;
	
	@Override
	public List<GoodsBean> selectIndexGoods(int begin, int end) {
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		// 查询商品的sql
		String goods_sql = "select goods_id,goods_name,goods_price from tb_goods limit ?,?";
		String image_sql = "select image_url from tb_image where goods_id = ?";

		Connection connection = dataSoureUtils.getConnection();
		PreparedStatement goodsPs = null;
		PreparedStatement imagePs = null;
		ResultSet goodsResult = null;
		ResultSet imageResult = null;
		try {
			goodsPs = connection.prepareStatement(goods_sql);
			imagePs = connection.prepareStatement(image_sql);

			// 查询
			goodsPs.setInt(1, begin);
			goodsPs.setInt(2, end);
			goodsResult = goodsPs.executeQuery();

			// 获取数据
			while (goodsResult.next()) {
				// 创建对象
				GoodsBean goodsBean = new GoodsBean();

				// 从结果集获取数据
				int goods_id = goodsResult.getInt("goods_id");
				goodsBean.setGoods_id(goods_id);
				goodsBean.setGoods_name(goodsResult.getString("goods_name"));
				goodsBean.setGoods_price(goodsResult.getDouble("goods_price"));

				// 继续查询商品对应的image_url
				imagePs.setInt(1, goods_id);
				imageResult = imagePs.executeQuery();
				List<String> imageList = new ArrayList<String>();
				while (imageResult.next()) {
					imageList.add(imageResult.getString("image_url"));
				}

				goodsBean.setImageList(imageList);

				// 将商品数据加入到集合
				goodsList.add(goodsBean);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			dataSoureUtils.close(goodsResult);
			dataSoureUtils.close(imageResult);
			dataSoureUtils.close(goodsPs);
			dataSoureUtils.close(imagePs);
			dataSoureUtils.close(connection);
		}

		return goodsList;
	}

	@Override
	public GoodsBean selectById(int id) {

		String goodsSql = "select * from tb_goods where goods_id = ?";
		String imageSql = "select image_url from tb_image where goods_id = ?";
		String sizeSql = "select size_info from tb_size where goods_id = ?";
		GoodsBean goodsBean = null;

		Connection connection = dataSoureUtils.getConnection();

		PreparedStatement goodsPs = null;
		PreparedStatement imagePs = null;
		PreparedStatement sizePs = null;
		ResultSet goodsRs = null;
		ResultSet imageRs = null;
		ResultSet sizeRs = null;
		try {
			goodsPs = connection.prepareStatement(goodsSql);
			goodsPs.setInt(1, id);
			// 查询
			goodsRs = goodsPs.executeQuery();
			if (goodsRs.next()) {
				goodsBean = new GoodsBean();
				goodsBean.setGoods_id(goodsRs.getInt("goods_id"));
				goodsBean.setCate_id(goodsRs.getInt("cate_id"));
				goodsBean.setGoods_desc(goodsRs.getString("goods_desc"));
				goodsBean.setGoods_name(goodsRs.getString("goods_name"));
				goodsBean.setGoods_price(goodsRs.getDouble("goods_price"));

				// ----------查询商品对应的图片-------------------
				imagePs = connection.prepareStatement(imageSql);
				imagePs.setInt(1, goodsBean.getGoods_id());
				// 查询
				List<String> imageList = new ArrayList<String>();

				imageRs = imagePs.executeQuery();
				while (imageRs.next()) {
					imageList.add(imageRs.getString("image_url"));
				}
				goodsBean.setImageList(imageList);
				// ----------查询商品对应的图片-------------------

				// ----------查询商品对应的size------------------
				sizePs = connection.prepareStatement(sizeSql);
				System.out.println(goodsBean.getGoods_id());
				sizePs.setInt(1, goodsBean.getGoods_id());
				sizeRs = sizePs.executeQuery();

				List<String> sizeList = new ArrayList<String>();

				while (sizeRs.next()) {
					sizeList.add(sizeRs.getString("size_info"));
				}

				goodsBean.setSizeList(sizeList);
				// ----------查询商品对应的size------------------

			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			dataSoureUtils.close(sizeRs);
			dataSoureUtils.close(imageRs);
			dataSoureUtils.close(goodsRs);
			dataSoureUtils.close(imagePs);
			dataSoureUtils.close(sizePs);
			dataSoureUtils.close(goodsPs);
			dataSoureUtils.close(connection);
		}

		return goodsBean;
	}

	@Override
	public List<GoodsBean> selectByCate(int cateId) {
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		// 查询商品的sql
		String goods_sql = "select goods_id,goods_name,goods_price,goods_desc,cate_id from tb_goods";
		if (cateId >= 0) {
			// 不分类
			goods_sql = "select goods_id,goods_name,goods_price,goods_desc,cate_id from tb_goods where cate_id = ?";
		}

		String image_sql = "select image_url from tb_image where goods_id = ?";

		Connection connection = dataSoureUtils.getConnection();
		PreparedStatement goodsPs = null;
		PreparedStatement imagePs = null;
		ResultSet goodsResult = null;
		ResultSet imageResult = null;
		try {
			goodsPs = connection.prepareStatement(goods_sql);
			imagePs = connection.prepareStatement(image_sql);

			// 查询
			if (cateId >= 0) {
				goodsPs.setInt(1, cateId);
			}
			goodsResult = goodsPs.executeQuery();

			// 获取数据
			while (goodsResult.next()) {
				// 创建对象
				GoodsBean goodsBean = new GoodsBean();

				// 从结果集获取数据
				int goods_id = goodsResult.getInt("goods_id");
				goodsBean.setGoods_id(goods_id);
				goodsBean.setGoods_name(goodsResult.getString("goods_name"));
				goodsBean.setGoods_price(goodsResult.getDouble("goods_price"));
				goodsBean.setGoods_desc(goodsResult.getString("goods_desc"));
				goodsBean.setCate_id(goodsResult.getInt("cate_id"));

				// 继续查询商品对应的image_url
				imagePs.setInt(1, goods_id);
				imageResult = imagePs.executeQuery();
				List<String> imageList = new ArrayList<String>();
				while (imageResult.next()) {
					imageList.add(imageResult.getString("image_url"));
				}

				goodsBean.setImageList(imageList);

				// 将商品数据加入到集合
				goodsList.add(goodsBean);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			dataSoureUtils.close(goodsResult);
			dataSoureUtils.close(imageResult);
			dataSoureUtils.close(goodsPs);
			dataSoureUtils.close(imagePs);
			dataSoureUtils.close(connection);
		}

		return goodsList;
	}

	/**
	 * 
	 * @param pageNum
	 *            : 页码
	 * @param pageSize
	 *            : 每页的数量
	 * @param cateId
	 * @return
	 */
	@Override
	public List<GoodsBean> selectByPageAndCate(int pageNum, int pageSize,
			int cateId) {
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		// 查询商品的sql: ? < 0 ---> cateId < 0 ,
		String goods_sql = "select * from tb_goods where ? < 0 limit ?,?";
		if (cateId >= 0) {
			// 不分类
			goods_sql = "select * from tb_goods where cate_id = ? limit ?,?";
		}

		String image_sql = "select image_url from tb_image where goods_id = ?";

		Connection connection = dataSoureUtils.getConnection();
		PreparedStatement goodsPs = null;
		PreparedStatement imagePs = null;
		ResultSet goodsResult = null;
		ResultSet imageResult = null;
		try {
			goodsPs = connection.prepareStatement(goods_sql);
			imagePs = connection.prepareStatement(image_sql);

			// 查询
			int begin = (pageNum - 1) * pageSize;
			if (begin < 0)
				begin = 0;
			goodsPs.setInt(1, cateId);
			goodsPs.setInt(2, begin);
			goodsPs.setInt(3, pageSize);

			goodsResult = goodsPs.executeQuery();

			// 获取数据
			while (goodsResult.next()) {
				// 创建对象
				GoodsBean goodsBean = new GoodsBean();

				// 从结果集获取数据
				int goods_id = goodsResult.getInt("goods_id");
				goodsBean.setGoods_id(goods_id);
				goodsBean.setGoods_name(goodsResult.getString("goods_name"));
				goodsBean.setGoods_price(goodsResult.getDouble("goods_price"));
				goodsBean.setGoods_desc(goodsResult.getString("goods_desc"));
				goodsBean.setCate_id(goodsResult.getInt("cate_id"));

				// 继续查询商品对应的image_url
				imagePs.setInt(1, goods_id);
				imageResult = imagePs.executeQuery();
				List<String> imageList = new ArrayList<String>();
				while (imageResult.next()) {
					imageList.add(imageResult.getString("image_url"));
				}

				goodsBean.setImageList(imageList);

				// 将商品数据加入到集合
				goodsList.add(goodsBean);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			dataSoureUtils.close(goodsResult);
			dataSoureUtils.close(imageResult);
			dataSoureUtils.close(goodsPs);
			dataSoureUtils.close(imagePs);
			dataSoureUtils.close(connection);
		}

		return goodsList;
	}

	@Override
	public int selectTotalPage(int cateId, int pageSize) {
		String sql = "select count(goods_id) from tb_goods";
		if (cateId >= 0) {
			sql = "select count(goods_id) from tb_goods where cate_id = "
					+ cateId;
		}
		Connection connection = dataSoureUtils.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			int totalSize = 0;
			//获取总的数据条数
			if (resultSet.next()) {
				totalSize = resultSet.getInt(1);
			}
			
			//计算总页数
			int pageCount = totalSize / pageSize;
			if (totalSize % pageSize != 0) {
				pageCount++;
			}
			
			return pageCount;
			 

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			dataSoureUtils.close(resultSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return 0;
	}

}
