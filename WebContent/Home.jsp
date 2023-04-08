<%@page import="com.facebook.dao.LikeDao"%>
<%@page import="java.sql.Connection"%>
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
	
	PostDao postDao = new PostDao(ConnectionProvider.getConnection());
	List<Post> postList = postDao.getAllPost();
%>

<!DOCTYPE html>
<html>
<head>

<%@include file="components/comman_css_js.jsp"%>
<%@include file="components/Post-Modal.jsp"%>

<title>Facebook-home</title>

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
.profile-img-size{
	height: 85px;
	width: 80px;
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
					<button class="btn btn-outline-light my-2 my-sm-0" 
					type="submit">Search</button>
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
					<!-- <li class="nav-item"><img id="profile-img" alt="image" src="image/profile-default-img2.png"
						class="img-circle"></li> -->
					
					<li class="nav-item"><a class="nav-link" href="Logout">
					<span class="fa fa-sign-out"></span> Logout</a></li>
				</ul>
			</div>
	</nav>



	<!-- Main Container -->
	<div class="container">

		<div class="row">
		
			
			<!-- Profile -->
			
			<div class="col-3">
				<div class="card mt-5" style="width: 12rem;">
	  				<img alt="image" src="image/<%=user.getProfilePic()%>"
					class="profile-img-size ml-5 mt-2">
					
					  <div class="card-body">
					    <h5 class="card-title ml-3">
					    <%=user.getfName()%> <%=user.getSurName()%></h5>
					 
					    <a href="Profile.jsp?uId=<%=user.getUserId() %>">
					    <button type="button" class="btn btn-primary ml-3">View Profile</button>
					    </a>
					  </div>
				</div>
			</div>

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
					 </div>	
					 
					<div class="card-footer mt-2">
					
					<% 
						LikeDao likeDao = new LikeDao(ConnectionProvider.getConnection());
					%>
						
						<a href="#" onclick="doLike(<%=p.getpId()%>,<%=user.getUserId()%>)" class="btn btn-outline-primary">
							<i class="fa fa-thumbs-o-up"></i>
							<span class="like-counter"><%=likeDao.countLikeonPost(p.getpId()) %></span></a>
							
						<a href="#" class="btn btn-primary">
							<i class="fa fa-commenting-o"></i>
							<span>10</span></a>
						
					</div>
					
			</div>
			<% } %>
			
		</div>
	</div>



</body>
</html>