package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountBean;
import bean.CartBean;
import bo.BillBo;
import bo.CartBo;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/BillController")
public class BillController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		long millis=System.currentTimeMillis();  
    	java.sql.Date date=new java.sql.Date(millis);
    	
    	try {
			BillBo bbo = new BillBo();
			AccountBean ac = (AccountBean) session.getAttribute("account");
			int userId = ac.getUserId();
			List<CartBean> cartList = (List<CartBean>) session.getAttribute("cart");
			bbo.addBill(userId, cartList);
			session.setAttribute("cbo",null);
			request.setAttribute("ThongBao", "BUY SUCCESSFULL !!");
			RequestDispatcher rd= request.getRequestDispatcher("confirm.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
