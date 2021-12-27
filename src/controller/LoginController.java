package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountBean;
import bo.LoginBo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	LoginBo loginBo = new LoginBo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charater=UTF-8");
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher rd = null;
		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		AccountBean account = loginBo.loginBo(userName, password);

		if (account != null) {
			session.setAttribute("account", account);
			if (account.isAdmin()) {
				response.sendRedirect("AdminController");
			} else {
				response.sendRedirect("HomeController");
			}
		} else {
			request.setAttribute("error", "Mật khẩu sai. Vui lòng thử lại");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}
