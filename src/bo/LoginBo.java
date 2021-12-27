package bo;

import bean.AccountBean;
import dao.LoginDao;

public class LoginBo {
	private LoginDao loginDao = new LoginDao();
	
	public AccountBean loginBo(String userName, String password) {
		return loginDao.loginDao(userName, password);
	}
}
