package bo;

import java.util.ArrayList;

import bean.CateBean;
import bean.ShoeBean;
import dao.CateDao;

public class CateBo {
	ArrayList<CateBean> ds;
	CateDao cdao = new CateDao();
	public ArrayList<CateBean> getcate() throws Exception {
		return cdao.getcate();
	}
	public boolean insertCateBo(CateBean cate) {
		return cdao.insertUserDao(cate);
	}

}
