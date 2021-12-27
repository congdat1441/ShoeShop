package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.HistoryBean;

public class HistoryDao {

	public ArrayList<HistoryBean> getLichSu(int userId) throws Exception {
		ArrayList<HistoryBean> ds = new ArrayList<HistoryBean>();
		DungChung dc = new DungChung();
		dc.ketNoi();
		String sql = "select * from VLS where UserId = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, userId);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int userId1 = rs.getInt("UserId");
			String fullName = rs.getString("FullName");
			String nameShoe = rs.getString("NameShoe");
			Long price = rs.getLong("Price");
			int count = rs.getInt("CountBuy");
			Boolean bought = rs.getBoolean("Bought");
			Long billDID = rs.getLong("BillDID");
			ds.add(new HistoryBean(userId1,  fullName,  nameShoe,  price,  count,  bought,	null));
		}
		cmd.close();
		rs.close();
		dc.cn.close();

		return ds;
	}

}
