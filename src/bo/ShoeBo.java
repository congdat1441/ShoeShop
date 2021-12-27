package bo;

import java.util.ArrayList;

import bean.ShoeBean;
import dao.ShoeDao;

public class ShoeBo {
	ArrayList<ShoeBean> ds;
	ShoeDao sdao = new ShoeDao();
	
	public ArrayList<ShoeBean> getshoe() throws Exception {
		ds= sdao.getshoe();		
		return ds;
	}

	public boolean insertShoeBo(ShoeBean shoe) {
		return sdao.insertShoeDao(shoe);
	}

	public ArrayList<ShoeBean> getTimShoe(String shoe) {
		return sdao.getTimShoeDao(shoe);
	}

	public ArrayList<ShoeBean> TimShoeCate(String cate) {
		return sdao.getTimShoeCate(cate);
	}


}
