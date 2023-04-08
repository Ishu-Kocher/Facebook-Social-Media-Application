package com.facebook.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebook.dao.UserDao;
import com.facebook.entities.User;
import com.facebook.helper.ConnectionProvider;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			HttpSession httpsession = request.getSession();
			UserDao userDao = new UserDao(ConnectionProvider.getConnection());
			User user = (User) httpsession.getAttribute("current-user");
			/* Update User Status */
			user.setStatus("Offline");
			userDao.UpdateUserStatus(user);
			/* remove session attribute */
			httpsession.removeAttribute("current-user");
			httpsession.setAttribute("message", "Logout Successfully !!");
			httpsession.setAttribute("eType", "alert-primary");
			response.sendRedirect("login.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
