package bo;

import java.util.ArrayList;

import bean.AccountBean;
import bean.ShoeBean;
import dao.AccountDao;
import dao.ShoeDao;

public class AccountBo {

	private AccountDao userDao = new AccountDao();
	
	public boolean insertUserBo(AccountBean user) {
		return userDao.insertUserDao(user);
	}
	ArrayList<AccountBean> ds;

	public ArrayList<AccountBean> getaccount() throws Exception{
		ds = userDao.getshoe();		
		return ds;
	}


}
