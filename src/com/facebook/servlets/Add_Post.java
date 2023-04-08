package com.facebook.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.facebook.dao.PostDao;
import com.facebook.entities.Post;
import com.facebook.entities.User;
import com.facebook.helper.ConnectionProvider;
import com.facebook.helper.ProfilePicSave;

/**
 * Servlet implementation class Add_Post
 */
@WebServlet("/Add_Post")
@MultipartConfig
public class Add_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Post() {
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
		
		// Getting form data 
		String pContent = request.getParameter("post-con");
		Part pPic = request.getPart("post-img");
		
		
		
		// Getting current user
		HttpSession session = request.getSession();
		User user= (User)session.getAttribute("current-user");
		
		// Save data in post object
		Post post = new Post(pContent, pPic.getSubmittedFileName(),null, user.getUserId());
		
		// Create PostDao object and send the all values
		PostDao postDao = new PostDao(ConnectionProvider.getConnection());
		boolean postSave = postDao.SavePost(post);
		if(postSave) {
			String path="D:\\EclipseJee2020-09\\Facebook\\WebContent\\postImages" + File.separator + pPic.getSubmittedFileName();
			if(!pPic.getSubmittedFileName().equals("")) {
				ProfilePicSave.SaveFile(pPic.getInputStream(), path);
			}
			session.setAttribute("message", "Post Updated Successfully!!");
			session.setAttribute("eType", "alert-success");
			response.sendRedirect("Home.jsp");
			return;
		}
		else {
			session.setAttribute("message", "Post not Updated !! Try again");
			session.setAttribute("eType", "alert-danger");
			response.sendRedirect("Home.jsp");
			return;
		}	
	}

}
