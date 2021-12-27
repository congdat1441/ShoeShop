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
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		CateBo cbo = new CateBo();
		ShoeBo sbo = new ShoeBo();
		ArrayList<CateBean> catelist;
		ArrayList<ShoeBean> shoelist = null;
		try {
			
			catelist = cbo.getcate();
			shoelist= sbo.getshoe();
			
			request.setAttribute("catelist", catelist);
			
			String shoe= request.getParameter("shoeName");
			String cate= request.getParameter("Category");
			if(shoe!=null) {
				shoelist = sbo.getTimShoe(shoe);

			}else if(cate!=null) {
				shoelist= sbo.TimShoeCate(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("shoelist", shoelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
