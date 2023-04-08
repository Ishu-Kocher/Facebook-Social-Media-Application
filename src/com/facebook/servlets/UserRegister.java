package com.facebook.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebook.dao.UserDao;
import com.facebook.helper.ConnectionProvider;
import com.facebook.entities.User;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		
		String fname=request.getParameter("fname");
		String surname=request.getParameter("surname");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pass");
		String dateOfBirth=request.getParameter("dateofbirth");
		String gender=request.getParameter("gender");
		
		UserDao userDao = new UserDao(ConnectionProvider.getConnection());
		
		int chk=userDao.getUserByEmail(email);
		if(chk==1) {
			HttpSession httpsession = request.getSession();
			httpsession.setAttribute("message", "User Email Already Register !! Try with another one");
			httpsession.setAttribute("eType", "alert-danger");
			response.sendRedirect("index.jsp");
			return;
		}else {
			User user = new User(fname,surname,email,pwd,dateOfBirth,gender,"profile-default-img2.png","offline");
			
			if(userDao.SaveUserDetails(user)) {
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("message", "Registration Successfully !!");
				httpsession.setAttribute("eType", "alert-primary");
				response.sendRedirect("index.jsp");
				return;
			}else {
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("message", "Something went wrong !! please try again");
				httpsession.setAttribute("eType", "alert-danger");
				response.sendRedirect("index.jsp");
				return;
			}

		}
	}
}
