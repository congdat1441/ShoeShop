package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.CartBean;

public class BillDao {

	public void addBill(int userId, Date date, boolean bought) {
		DungChung dc = new DungChung();
		dc.ketNoi();
		String sql = "INSERT INTO Bill(UserId, DateBuy, Bought)\r\n"
				+ "VALUES (?,?,?)";
		PreparedStatement cmd;
		try {
			cmd = dc.cn.prepareStatement(sql);
			cmd.setLong(1, userId);
			cmd.setDate(2, date);
			cmd.setBoolean(3, bought);
			cmd.executeUpdate();
			cmd.close();
			dc.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public long getBillIdMax() {
		long billId = 0;
		DungChung dc = new DungChung();
		dc.ketNoi();
		String sql = "SELECT MAX(BillId) + 1 FROM Bill";
		PreparedStatement cmd = null;
		ResultSet rs = null;
		try {
			cmd = dc.cn.prepareStatement(sql);
			rs = cmd.executeQuery();
			while (rs.next()) {
				billId = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				cmd.close();
				dc.cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return billId;
	}

	public void insertBill(int userId, List<CartBean> cartList) throws SQLException {
		DungChung dc = new DungChung();
		dc.ketNoi();
		String sql = "INSERT INTO Bill(UserId, DateBuy, Bought, ShoeID, QuatityItem, BillID) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		long billId = getBillIdMax();
		for (CartBean cartBean: cartList) {
			cmd.setInt(1, userId);
			cmd.setDate(2, new Date(System.currentTimeMillis()));
			cmd.setBoolean(3, false);
			cmd.setString(4, cartBean.getShoeBean().getShoeID());
			cmd.setInt(5, cartBean.getQuantity());
			cmd.setLong(6, billId);
			cmd.executeUpdate();
		}
		cmd.close();
		dc.cn.close();
	}

}
