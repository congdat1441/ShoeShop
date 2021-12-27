package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ShoeBean;

public class ShoeDao {

	public ArrayList<ShoeBean> getshoe() throws Exception {
		ArrayList<ShoeBean> ds = new ArrayList<ShoeBean>();
		DungChung dc= new DungChung();
		dc.ketNoi();
		String sql = "select* from Shoe";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String shoeID= rs.getString("ShoeID");
			String nameShoe= rs.getString("NameShoe");
			Long count = rs.getLong("Count");
			Long price = rs.getLong("Price");
			String cateID = rs.getString("CateID");
			String photo = rs.getString("Photo");
			ds.add(new ShoeBean(shoeID,  nameShoe, count, price, cateID, photo));
		}
		
		rs.close();
		dc.cn.close();
		return ds;
	}

	public boolean insertShoeDao(ShoeBean shoe) {
		boolean result = false;
		DungChung dc = new DungChung();
		dc.ketNoi();
		Connection cn = dc.cn;
		PreparedStatement ps = null;
		String sql = "INSERT INTO SHOE (ShoeID, NameShoe, Count, Price, CateID, Photo) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, shoe.getShoeID());
			ps.setString(2, shoe.getNameShoe());
			ps.setLong(3, shoe.getCount());
			ps.setLong(4, shoe.getPrice());
			ps.setString(5, shoe.getCateID());
			ps.setString(6, shoe.getPhoto());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}

	public ArrayList<ShoeBean> getTimShoeDao(String shoe) {
		ArrayList<ShoeBean> ds = new ArrayList<ShoeBean>();

		try {
			DungChung dc = new DungChung();
			dc.ketNoi();
			String sql = "select * from SHOE where NameShoe like ?";
			PreparedStatement ps;
			ps = dc.cn.prepareStatement(sql);
			ps.setString(1, "%" + shoe + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String shoeID = rs.getString("ShoeID");
				String nameShoe = rs.getString("NameShoe");
				Long count = rs.getLong("Count");
				
				Long price = rs.getLong("Price");
				String cateID = rs.getString("CateID");
				String photo = rs.getString("Photo");

				ds.add(new ShoeBean( shoeID,  nameShoe,  count,  price,  cateID,  photo));
			}
			rs.close();
			dc.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ds;
	}

	public ArrayList<ShoeBean> getTimShoeCate(String cate) {
		ArrayList<ShoeBean> ds = new ArrayList<ShoeBean>();

		try {
			DungChung dc = new DungChung();
			dc.ketNoi();
			String sql = "select * from SHOE where CateID like ?";
			PreparedStatement ps;
			ps = dc.cn.prepareStatement(sql);
			ps.setString(1, cate );
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String shoeID = rs.getString("ShoeID");
				String nameShoe = rs.getString("NameShoe");
				Long count = rs.getLong("Count");
				Long price = rs.getLong("Price");
				String cateID = rs.getString("CateID");
				String photo = rs.getString("Photo");

				ds.add(new ShoeBean( shoeID,  nameShoe,  count,  price,  cateID,  photo));
			}
			rs.close();
			dc.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ds;
	}

}
