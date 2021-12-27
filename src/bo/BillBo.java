package bo;

import java.sql.Date;
import java.util.List;

import bean.CartBean;
import dao.BillDao;

public class BillBo {
	BillDao bdao = new BillDao();
	public void UpdateBill(int userId, Date date, boolean bought) throws Exception {
		bdao.addBill(userId,date, bought);
		
	}

	public Long getbillIdMax()  throws Exception{
		Long billId = bdao.getBillIdMax();
		return billId;
	}

	public void addBill(int userId, List<CartBean> cartList) throws Exception {
		bdao.insertBill(userId, cartList);
	}

}
