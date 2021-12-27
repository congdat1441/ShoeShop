package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CateBean;
import bean.ShoeBean;
import bo.CateBo;
import bo.ShoeBo;

/**
 * Servlet implementation class AdminCategory
 */
@WebServlet("/AdminCategory")
public class AdminCategory extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		CateBo cbo = new CateBo();
		ShoeBo sbo = new ShoeBo();
		
		ArrayList<CateBean> catelist;
		ArrayList<ShoeBean> shoelist;
		try {
			catelist = cbo.getcate();
			shoelist= sbo.getshoe();
			
			request.setAttribute("catelist", catelist);
			request.setAttribute("shoelist", shoelist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Admin/categoryA.jsp");
		dispatcher1.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
