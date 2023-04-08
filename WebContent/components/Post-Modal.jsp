<%@page import="java.util.List"%>
<%@page import="com.facebook.helper.ConnectionProvider"%>
<%@page import="com.facebook.dao.UserDao"%>
<%@page import="com.facebook.entities.User"%>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	User user1 = (User) session.getAttribute("current-user");

	if (user1 == null) {
		session.setAttribute("message", "You are not logged in !! Login First");
		session.setAttribute("eType", "alert-danger");
		response.sendRedirect("login.jsp");
		return;
	}
%>


<style>
#text-area, text-area:focus {
	outline: none;
	border: none;
}
</style>

<!-- Modal -->
<div class="modal fade" id="post" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
      	<div class="container text-center">
        <h5 class="modal-title" id="exampleModalLongTitle">Create post</h5>
        </div>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
        	<form action="Add_Post" method="post" enctype="multipart/form-data">
        		<img id="profile-img" alt="image" src="image/<%=user1.getProfilePic()%>"
					class="img-circle"> <a href="#" class="text-primary">
					<% out.print(user1.getfName()); %> 
					<% out.print(user1.getSurName()); %></a> <br>
				<div class="form-group mt-3">
				<textarea id="text-area" rows="10" cols="55"
					placeholder="What's on your mind, John?" name="post-con"></textarea>
					
					<h5 class="text-light bg-dark">upload image & file</h5>
					<span class="fa fa-upload"></span>
					<input type="file" name="post-img" value="image">
					
				</div>  
        
        
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-primary btn-sm btn-block">Post</button>
        </form>
      </div>
      
    </div>
  </div>
</div>