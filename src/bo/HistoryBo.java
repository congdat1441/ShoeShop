package bo;

import java.util.ArrayList;

import bean.HistoryBean;
import dao.HistoryDao;

public class HistoryBo {
	HistoryDao htdao = new HistoryDao();
	public ArrayList<HistoryBean> getLichSubo (int userId) throws Exception{
		return htdao.getLichSu(userId);
	}

}
