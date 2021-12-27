package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.AccountBean;
import bean.ShoeBean;

public class AccountDao {

	public boolean insertUserDao(AccountBean user) {
		boolean result = false;
		DungChung dc = new DungChung();
		dc.ketNoi();
		Connection cn = dc.cn;
		PreparedStatement ps = null;
		String sql = "INSERT INTO Account (FullName, UserName, Password, Email, Address, PhoneNumber, IsAdmin) "
				+ "VALUES (?, ?, ?, ?, ?, ?, 0)";
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getPhoneNumber());
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

	public ArrayList<AccountBean> getAccount() throws Exception {
		ArrayList<AccountBean> ds = new ArrayList<AccountBean>();
		DungChung dc = new DungChung();
		dc.ketNoi();
		String sql = "select* from Account";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int userId = rs.getInt("UserId");
			String userName = rs.getString("UserName");
			String fullName = rs.getString("FullName");
			String password = rs.getString("Password");
			String address = rs.getString("Email");
			String email = rs.getString("Address");
			String phoneNumber1 = rs.getString("PhoneNumber");
			ds.add(new AccountBean(fullName, userName, password, address, email, phoneNumber1));
		}

		rs.close();
		dc.cn.close();
		return ds;
	}

	public ArrayList<AccountBean> getshoe() throws Exception{
		ArrayList<AccountBean> ds = new ArrayList<AccountBean>();
		DungChung dc = new DungChung();
		dc.ketNoi();
		String sql = "select* from Account";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int userId = rs.getInt("UserId");
			String fullName = rs.getString("FullName");
			String userName = rs.getString("UserName");
			String password= rs.getString("Password");
			String address = rs.getString("Address");
			String email = rs.getString("Email");
			String phoneNumber = rs.getString("PhoneNumber");
			ds.add(new AccountBean(fullName, userName, password, address, email, phoneNumber));
		}
		
		rs.close();
		dc.cn.close();
		return ds;
	}
}
