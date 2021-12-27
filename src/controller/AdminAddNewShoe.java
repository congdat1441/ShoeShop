package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;

import bean.AccountBean;
import bean.ShoeBean;
import bo.AccountBo;
import bo.ShoeBo;

/**
 * Servlet implementation class AdminAddNew
 */
@WebServlet("/AdminAddNewShoe")
public class AdminAddNewShoe extends HttpServlet {
	
	private ShoeBo shoeBo = new ShoeBo();
	private final String UPLOAD_DIRECTORY = "F:\\workspace\\ShoeShop\\WebContent\\img";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/formaddshoeA.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dis = null;
		
		// process only if its multipart content
		Map<String, Object> map = getParameter(request, response);
		ShoeBean shoe = (ShoeBean) map.get("shoeBean");
		String errorMessage = (String) map.get("errorMessage");
		if (errorMessage != null) {
			request.setAttribute("errorMessage", errorMessage);
			dis = request.getRequestDispatcher("/Admin/formaddshoeA.jsp");
		} else {
			if (shoeBo.insertShoeBo(shoe)) {
				request.setAttribute("successMessage", "Đăng ký thành công");
				dis = request.getRequestDispatcher("AdminProduction");
			} else {
				request.setAttribute("errorMessage", "Create Fail");
				dis = request.getRequestDispatcher("/Admin/formaddshoeA.jsp");
			}
		}

		dis.forward(request, response);
		
	}

	private Map<String, Object> getParameter(HttpServletRequest request, HttpServletResponse response) {
		String shoeID = null;
		String nameShoe = null;
		Long count = null;
		Long price = null;
		String cateID = null;
		String photo = null;
		Map<String, Object> map = new HashMap<String, Object>();
		

		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						String extension = FilenameUtils.getExtension(name);
						Pattern pattern = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
						if (!pattern.matcher(name).matches()) {
							map.put("errorMessage", "File upload must be image");
							return map;
						}

						name = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name + "." + extension));
						photo = "img/" + name + "." + extension;
					} else {
						String fieldname = item.getFieldName();
						String fieldvalue = item.getString();
						if (fieldname.equals("shoeID")) {
							shoeID = fieldvalue;
						} else if (fieldname.equals("nameShoe")) {
							nameShoe = fieldvalue;
						} else if (fieldname.equals("count")) {
							count = "".equals(fieldvalue) ? 0L : Long.parseLong(fieldvalue);
						} else if (fieldname.equals("price")) {
							price = "".equals(fieldvalue) ? 0L : Long.parseLong(fieldvalue);
						} else {
							cateID = fieldvalue;
						}
					}
				}

				// File uploaded successfully
				ShoeBean shoeBean = new ShoeBean( shoeID, nameShoe, count, price, cateID, photo);
				map.put("shoeBean", shoeBean);
			} catch (Exception ex) {
				ex.printStackTrace();
				map.put("errorMessage", "File Upload Failed");
			}

		} else {
			map.put("errorMessage", "Sorry this Servlet only handles file upload request");
		}
		return map;
	}
	
}
