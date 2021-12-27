package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ShoeBean;

public class CartDao {

	public ShoeBean getShoe(String shoeID) {
		ArrayList<ShoeBean> ds = new ArrayList<ShoeBean>();
		DungChung dc= new DungChung();
		dc.ketNoi();
		String sql = "select* from Shoe where ShoeID = ?";
		PreparedStatement cmd;
		ShoeBean shoe = null;
		try {
			cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, shoeID);
			ResultSet rs = cmd.executeQuery();
			
			while(rs.next()) {
				String shoeId= rs.getString("ShoeID");
				String nameShoe= rs.getString("NameShoe");
				Long count = rs.getLong("Count");
				Long price = rs.getLong("Price");
				String cateID = rs.getString("CateID");
				String photo = rs.getString("Photo");
				shoe = new ShoeBean(shoeID, nameShoe, count, price, cateID, photo);
				
			}
			cmd.close();
			rs.close();
			dc.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return shoe;
		
	}
	
}
