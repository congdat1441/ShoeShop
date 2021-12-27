package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import bean.ShoeBean;
import bo.CartBo;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	CartBo cbo = new CartBo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartBean> cartList = null;

		if (session.getAttribute("cart") == null) {
			cartList = new ArrayList<CartBean>();
			session.setAttribute("cart", cartList);
		}
		// Add shoe
		if (request.getParameter("add") != null) {
			cartList = (ArrayList<CartBean>) session.getAttribute("cart");

			String shoeID = request.getParameter("ShoeID");
			settingShoeQuantity(shoeID, cartList);
			session.setAttribute("cart", cartList);
		}

		// Delete shoe
		String deleteShoeId = request.getParameter("deleteShoeId");
		String delete = request.getParameter("delete");
		if (delete != null) {
			cartList = (List<CartBean>) session.getAttribute("cart");
			for (CartBean cartbean : cartList) {
				if (deleteShoeId.equals(cartbean.getShoeBean().getShoeID())) {
					cartList.remove(cartbean);
					break;
				}
			}
			session.setAttribute("cart", cartList);
		}
		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
	}

	private void settingShoeQuantity(String shoeID, List<CartBean> cartList) {
		boolean isExist = false;
		for (CartBean cartBean : cartList) {
			if (shoeID.equals(cartBean.getShoeBean().getShoeID())) {
				cartBean.setQuantity(cartBean.getQuantity() + 1);
				cartBean.setPriceItem(cartBean.getQuantity() * cartBean.getShoeBean().getPrice());
				isExist = true;
			}
		}

		if (!isExist) {
			ShoeBean shoe = cbo.getShoeById(shoeID);
			cartList.add(new CartBean(1, shoe.getPrice(), shoe));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartBean> cartList = (ArrayList<CartBean>) session.getAttribute("cart");
		String[] quantites = request.getParameterValues("qty");
		int index = 0;

		if (cartList != null) {
			for (CartBean cartBean : cartList) {
				int quantity = Integer.parseInt(quantites[index++]);
				cartBean.setQuantity(quantity);
				cartBean.setPriceItem(cartBean.getQuantity() * cartBean.getShoeBean().getPrice());
			}
			session.setAttribute("cart", cartList);
		}

		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
	}

}
