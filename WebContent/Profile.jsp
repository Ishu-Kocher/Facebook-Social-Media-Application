<%@page import="com.facebook.entities.Post"%>
<%@page import="com.facebook.dao.PostDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.facebook.helper.ConnectionProvider"%>
<%@page import="com.facebook.dao.UserDao"%>
<%@page import="com.facebook.entities.User"%>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	User user = (User) session.getAttribute("current-user");

	//int uId = Integer.parseInt(request.getParameter("uId"));
	
	if (user == null) {
		session.setAttribute("message", "You are not logged in !! Login First");
		session.setAttribute("eType", "alert-danger");
		response.sendRedirect("login.jsp");
		return;
	}
%>

<%
	UserDao userDao = new UserDao(ConnectionProvider.getConnection());
	/* List<User> list = userDao.getAllUsersNameAndStatus(); */
	
	int uId = Integer.parseInt(request.getParameter("uId"));
	User profileUser = userDao.getUserById(uId);
	
	PostDao postDao = new PostDao(ConnectionProvider.getConnection());
	List<Post> postList = postDao.getAllPostByCurrentUser(uId);
%>

<!DOCTYPE html>
<html>
<head>

<%@include file="components/comman_css_js.jsp"%>
<%@include file="components/Post-Modal.jsp"%> 
<%@include file="components/Profile-Model.jsp"%>

<title>Facebook-profile</title>

<style>
#home-body {
	background: #F8F8F8 !important;
}

#card-btn {
	margin-left: 400px;
}

#profile-img {
	height: 45px;
	width: 40px;
}

#style-card {
	border-top: 5px solid #43609C;
}

#profile-cover{
	height: 340px;
	background-image: url("image/Facebook-Cover2.png");
	background-repeat: no-repeat;
   	background-size: 100% 100%;
   	position: relative;
}

#profile-image img{
	height: 168px;
	width: 168px;
	margin-top: 150px;
}



</style>

</head>
<body id="home-body">

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark" id="navBar">
		<div class="container">
			<a class="navbar-brand" href="Home.jsp">Facebook</a>

			<nav class="navbar navbar-light bg-light" id="navBar">
				<form action="#" class="form-inline">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
				</form>
			</nav>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">

					<li class="nav-item"><a class="nav-link" href="Logout"> <span
							class="fa fa-sign-out"></span> Logout
					</a></li>
				</ul>
			</div>
	</nav>



	<!-- Main Container -->
	<div class="container">

		<div class="jumbotron mt-2" id="profile-cover">
		
			<div class="container">
				<div class="text-center" id="profile-image">
					<img alt="profile-image" src="image/<%=profileUser.getProfilePic()%>"
						class="img-circle">
				</div>
			</div>
			
		</div>
		
		
			<div class="text-right" id="profile-edit">
				<p class="display-4 text-center mt-5 font-weight-bold">
				<%=profileUser.getfName()%> <%=profileUser.getSurName()%></p>
			
				<a href="#">
					<button class="btn btn-primary">
						<span class="fa fa-user-plus"></span> Add Friend
					</button>
				</a> 
				<a href="#" data-toggle="modal" data-target="#Profile-modal">
					<button class="btn btn-primary">
						<span class="fa fa-edit"></span> Edit Profile
					</button>
				</a>
			</div>

		

		
		
		<div class="row">

			<!-- Post -->
			<div class="col-3"></div> 
			
			<!-- Post -->
			<div class="col-8">
			
				<div class="card mt-5" id="style-card" style="width: 35rem;">
					
					<div class="card-body">
						<img id="profile-img" alt="image" src="image/<%=user.getProfilePic()%>"
							class="img-circle"> 
							<a href="#" id="card-btn"
							data-toggle="modal" data-target="#post" class="btn btn-primary">POST</a>
					</div>
					
				</div>

				<div  style="width: 35rem;">
					<%@include file="components/Message.jsp"%>
				</div>

				<!-- Display All Posts -->
				<% 
				
					for(Post p : postList){
						User postUser = userDao.getUserById(p.getuId());
				%>
				<div class="card mt-5" style="width: 35rem;">
						<div class="card-header">
							<img id="profile-img" alt="image" src="image/<%=postUser.getProfilePic()%>"
								class="img-circle"> <a href="#" class="text-primary font-weight-bold">
								<%=postUser.getfName()%> <%=postUser.getSurName()%></a>
	
							<p class="mt-1 font-italic font-weight-light"><%=p.getDateTime().toLocaleString()%></p>
						</div>
						
					<div class="card-body">
						<p class="card-text"><%=p.getpContent()%></p>
				<% 
					if(p.getpPic().equals("")){
						
					}else{
				%>	
						<img alt="image" src="postImages/<%=p.getpPic()%>" class="card-img-top"> 
				<% } %>		
						<a href="#" class="btn btn-primary mt-3">
							<span class="fa fa-thumbs-up"></span> 960K</a>
					 </div>	
					 
					<div class="card-footer mt-2">
						<div class="input-group mb-2">
							<input type="text" class="form-control"
								placeholder="Write a comment..."
								aria-label="Recipient's username"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<a href="#" class="btn btn-primary">Post
								<span class="fa fa-comment"></span></a>
							</div>
						 </div>
					</div>
					
			</div>
			<% } %>

		</div>

	</div>
	
	<div class="col-1"></div>
	
	
	
	
	
	
</body>
</html>