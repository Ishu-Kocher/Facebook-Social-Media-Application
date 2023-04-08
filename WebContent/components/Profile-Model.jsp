<%@page import="java.util.List"%>
<%@page import="com.facebook.helper.ConnectionProvider"%>
<%@page import="com.facebook.dao.UserDao"%>
<%@page import="com.facebook.entities.User"%>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	User profile_user = (User) session.getAttribute("current-user");

	if (profile_user == null) {
		session.setAttribute("message", "You are not logged in !! Login First");
		session.setAttribute("eType", "alert-danger");
		response.sendRedirect("login.jsp");
		return;
	}
%>


<!-- Profile Modal -->
	<!-- Modal -->
	<div class="modal fade" id="Profile-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-white" style="background: #43609C;">
					<div class="text-center container">
						<h5 class="modal-title" id="exampleModalLabel">Facebook</h5>
					</div>
				</div>
				<div class="modal-body">

					<div class="container text-center">
						<%
							if (profile_user.getProfilePic().equals("default.jpg")) {
						%>
						<img class="img-fluid rounded-circle" alt="profile-pic"
							src="pic/<%=profile_user.getProfilePic()%>" style="max-width: 150px;">
						<%
							} else {
						%>
						<img class="img-fluid rounded-circle" alt="profile-pic"
							src="image/<%=profile_user.getProfilePic()%>" style="max-width: 150px;">

						<%
							}
						%>

						<h1 class="display-4"><%=profile_user.getfName()%> <%=profile_user.getSurName()%></h1>

						<!-- Profile Details -->
						<div id="profile-details">
							<table class="table">
								<tbody>

									<tr>
										<th scope="row">Email :</th>
										<td><%=profile_user.getEmail()%></td>
									</tr>

									<tr>
										<th scope="row">Password :</th>
										<td><%=profile_user.getPassword()%></td>
									</tr>
									
									<tr>
										<th scope="row">Gender :</th>
										<td><%=profile_user.getGender()%></td>
									</tr>
									
									<tr>
										<th scope="row">Date of Birth :</th>
										<td><%=profile_user.getDateOfBirth()%></td>
									</tr>

								</tbody>
							</table>
						</div>

						<!-- Profile Edit -->
						<div id="profile-edit" style="display: none;">
							<form action="EditUserDetails" method="post"
								enctype="multipart/form-data">
								<h3>Please edit carefully!!</h3>
								<table class="table mt-2">
									<tbody>

										<tr>
											<th scope="row">First Name :</th>
											<td><input type="text" name="fname"
												value="<%=profile_user.getfName()%>" class="form-control"></td>
										</tr>
										
										<tr>
											<th scope="row">Surname :</th>
											<td><input type="text" name="surname"
												value="<%=profile_user.getSurName()%>" class="form-control"></td>
										</tr>

										<tr>
											<th scope="row">Email :</th>
											<td><input type="text" name="uemail"
												value="<%=profile_user.getEmail()%>" class="form-control" disabled></td>
										</tr>

										<tr>
											<th scope="row">Password :</th>
											<td><input type="password" name="upass"
												value="<%=profile_user.getPassword()%>" class="form-control" disabled></td>
										</tr>
										

										<tr>
											<th scope="row">New profile pic :</th>
											<td><input type="file" name="profilePic"
												value="<%=profile_user.getProfilePic()%>" class="form-control"></td>
										</tr>
									</tbody>
								</table>
								<div class="container text-center">
									<input type="submit" value="Save" class="btn btn-success">
								</div>
						</div>
						</form>


					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="edit-profile-btn" type="button" class="btn btn-primary">Edit</button>
				</div>
			</div>
		</div>
	</div>


	<script>
	
		
			
		$(document).ready(function() {
			
			let editStatus = false;

			$('#edit-profile-btn').click(function() {

				if (editStatus == false) {

					$("#profile-details").hide();
					$("#profile-edit").show();
					editStatus = true;
					$(this).text("Back");
				} else {
					$("#profile-details").show();
					$("#profile-edit").hide();
					editStatus = false;
					$(this).text("Edit");
				}

			})

		});
	</script>
