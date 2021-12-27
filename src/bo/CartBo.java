package bo;

import java.util.ArrayList;

import bean.CartBean;
import bean.ShoeBean;
import dao.CartDao;

public class CartBo {

	public ArrayList<CartBean> ds = new ArrayList<CartBean>();
	CartDao cdao = new CartDao();

//	public void add(String shoeID, String nameShoe, long price, long count) {
//		for(CartBean cart : ds) {
//			if(cart.getShoeID().equals(nameShoe)) {
//				cart.setCount(cart.getCount() + count);
//				return;
//			}
//		}
//		ds.add(new CartBean(shoeID, nameShoe, price, count));
//	}
	

//	public void delete(String shoeID) {
//		if (shoeID.equals("allshoe")) {
//			ds.clear();
//		} else {
//			for (CartBean cart : ds) {
//				if (cart.shoeBean.getShoeID().equals(shoeID)) {
//					ds.remove(cart);
//					return;
//				}
//			}
//		}
//		
//	}
//
//	public void Update(String shoeID, long count) {
//		for (CartBean cart : ds) {
//			if (cart.getShoeID().equals(shoeID)) {
//				cart.setCount(count);
//				return;
//			}
//		}
//		
//	}
//	
//	public long payment() {
//		long s = (long) 0;
//		for (CartBean cart : ds) {
//			s += cart.getPayment();
//		}
//		return s;
//	}


	public ShoeBean getShoeById(String shoeID) {
		return cdao.getShoe(shoeID);
		
	}

}
