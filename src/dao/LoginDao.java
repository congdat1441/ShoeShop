package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AccountBean;

public class LoginDao {
	public boolean isUserNameExists(String userName) {
		boolean result = false;
		DungChung dc = new DungChung();
		PreparedStatement stmt;
		ResultSet rs;
		String sql =  "Select COUNT(UserName) as soLuong from Account where UserName = ?";
		
		dc.ketNoi();
		try {
			stmt = dc.cn.prepareStatement(sql);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("soluong") ==0 ? false : true ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public AccountBean loginDao(String userName, String password) {
		DungChung dc = new DungChung();
		PreparedStatement ps = null;
		ResultSet rs = null;
		AccountBean account = null;
		String sql = "SELECT * FROM Account WHERE UserName = ? AND Password = ?";
		
		dc.ketNoi();
		try {
			ps = dc.cn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				account = new AccountBean();
				account.setAddress(rs.getString("Address"));
				account.setAdmin(rs.getBoolean("IsAdmin"));
				account.setEmail(rs.getString("Email"));
				account.setFullName(rs.getString("FullName"));
				account.setPassword(rs.getString("Password"));
				account.setPhoneNumber(rs.getString("PhoneNumber"));
				account.setUserId(rs.getInt("UserId"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dc.cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return account;
		
	}
}
