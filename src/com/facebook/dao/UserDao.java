package com.facebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.facebook.entities.Post;
import com.facebook.entities.User;

public class UserDao {

	private Connection con;
	
	// Constructor
	public UserDao(Connection con) {
		this.con = con;
	}

	// Save user details to database	
	public boolean SaveUserDetails(User user) {
		boolean userSave = false;
		try {
			String query="insert into userdetails(fName,surName,email,password,dateOfBirth,gender,profilePic,status) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = this.con.prepareStatement(query);

			ps.setString(1, user.getfName());
			ps.setString(2, user.getSurName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getDateOfBirth());
			ps.setString(6, user.getGender());
			ps.setString(7, user.getProfilePic());
			ps.setString(8, user.getStatus());
			
			ps.executeUpdate();
			userSave = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return userSave;
	}
	
	// Check email already show in database or not	
	public int getUserByEmail(String email) {
		int i=0;
		try {
			String query="select count(*) from userdetails where email='"+email+"'";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			rs.next();
			i = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	// Check email or password valid or not	
	public User getUserByEmailAndPassword(String email, String pwd) {
		User userDetails=null;
		try {
			String query="select * from userdetails where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pwd);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				userDetails = new User();
				userDetails.setUserId(rs.getInt(1));
				userDetails.setfName(rs.getString(2));
				userDetails.setSurName(rs.getString(3));
				userDetails.setEmail(rs.getString(4));
				userDetails.setPassword(rs.getString(5));
				userDetails.setDateOfBirth(rs.getString(6));
				userDetails.setGender(rs.getString(7));
				userDetails.setProfilePic(rs.getString(8));
				userDetails.setStatus(rs.getString(9));
			}
			
		}catch(Exception e) {e.printStackTrace();}
		
		
		return userDetails;
	}
	
	// Update User Details	
	public boolean UpdateUser(User user) {
		boolean f=false;
		try {
			String query="update User set name=?, password=?, phone=?, profile_pic=? where id=?";
			PreparedStatement ps = this.con.prepareStatement(query);
			/*
			 * ps.setString(1, user.getName()); ps.setString(2, user.getPassword());
			 * ps.setString(3, user.getPhone()); ps.setString(4, user.getProfile_pic());
			 * 
			 * ps.setInt(5, user.getId());
			 */			ps.executeUpdate();
			f=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return f;
	}
	
	// Get User name and status	
	public ArrayList<User> getAllUsersNameAndStatus(){
		
		ArrayList<User> list = new ArrayList<>();
		try {
			
			String query="select id,fName,surName,profilePic,status from userdetails";
			Statement st = this.con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				int uId = rs.getInt(1); 
				String fName = rs.getString(2);
				String surName = rs.getString(3);
				String pic = rs.getString(4);
				String status = rs.getString(5);
				User u = new User();
				u.setUserId(uId);
				u.setfName(fName);
				u.setSurName(surName);
				u.setProfilePic(pic);
				u.setStatus(status);
				list.add(u);
			}
			
		}catch(Exception e) {e.printStackTrace();}
		
		return list;
	}
	
	// Update User Status	
	public boolean UpdateUserStatus(User user) {
		boolean updateStatus = false;
		try {
			String query="update userdetails set status=? where id=?";
			PreparedStatement ps = this.con.prepareStatement(query);
			
			ps.setString(1, user.getStatus());
			ps.setInt(2, user.getUserId());
			
			ps.executeUpdate();
			updateStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return updateStatus;
	}
		
	
	// Get user by Id
	public User getUserById(int uId) {
		
		User user = null;
		
		try {
			// Fetching all the post
			PreparedStatement ps = con.prepareStatement("select * from userdetails  where id='"+uId+"'");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				user = new User();
				
				user.setUserId(rs.getInt("id"));
				user.setfName(rs.getString("fName"));
				user.setSurName(rs.getString("surName"));
				user.setEmail( rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setDateOfBirth(rs.getString("dateOfBirth"));
				user.setGender(rs.getString("gender"));
				user.setProfilePic(rs.getString("profilePic"));
				user.setStatus(rs.getString("status"));
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
	
}
