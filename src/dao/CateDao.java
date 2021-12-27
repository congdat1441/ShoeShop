package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CateBean;
import bean.ShoeBean;

public class CateDao {
	public ArrayList<CateBean> getcate() {
		ArrayList<CateBean> ds = new ArrayList<>();
		DungChung dc = new DungChung();
		dc.ketNoi();
		try {
			String sql = "select * from Category";
			PreparedStatement cmd;
			cmd = dc.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String cateID = rs.getString("CateID");
				String cateName = rs.getString("CateName");
				ds.add(new CateBean(cateID, cateName));

			}
			rs.close();
			dc.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public boolean insertUserDao(CateBean cate) {
		boolean result = false;
		DungChung dc = new DungChung();
		dc.ketNoi();
		Connection cn = dc.cn;
		PreparedStatement ps = null;
		String sql = "INSERT INTO Category (CateID, CateName) "
				+ "VALUES (?, ?)";
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, cate.getCateID());
			ps.setString(2, cate.getCateName());
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



}
