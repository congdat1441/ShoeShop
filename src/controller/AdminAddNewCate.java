package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AccountBean;
import bean.CateBean;
import bo.CateBo;

/**
 * Servlet implementation class AdminAddNewCate
 */
@WebServlet("/AdminAddNewCate")
public class AdminAddNewCate extends HttpServlet {
	
	private CateBo catebo = new CateBo();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Admin/formaddcateA.jsp");
		dispatcher1.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String cateID = request.getParameter("CateID");
		String cateName = request.getParameter("CateName");
		
		CateBean cate = new CateBean(cateID, cateName);
		if (catebo.insertCateBo(cate)) {
			request.setAttribute("successMessage", "Create successfull");
			response.sendRedirect("AdminCategory");
		}else {
			request.setAttribute("errorMessage", "Create Fail");
			RequestDispatcher dis = request.getRequestDispatcher("/Admin/formaddcateA.jsp");
			dis.forward(request, response);
		}
	}

}
