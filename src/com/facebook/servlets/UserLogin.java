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
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("userEmail");
		String pwd=request.getParameter("userPwd");
		
		UserDao userDao = new UserDao(ConnectionProvider.getConnection());
		
		User userDetails=userDao.getUserByEmailAndPassword(email, pwd);
		
		HttpSession httpsession = request.getSession();
		if(userDetails == null) {
			httpsession.setAttribute("message", "Invalid Login Details !! Try with another one");
			httpsession.setAttribute("eType", "alert-danger");
			response.sendRedirect("login.jsp");
			return;
		}else {
			httpsession.setAttribute("current-user", userDetails);
			/* Update User Status */
			userDetails.setStatus("Online");
			userDao.UpdateUserStatus(userDetails);
			/* redirect to home page */
			response.sendRedirect("Home.jsp");
		}
	
		
	}

}
