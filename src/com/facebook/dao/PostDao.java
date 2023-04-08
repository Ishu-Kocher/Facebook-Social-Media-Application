package com.facebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.facebook.entities.Post;

public class PostDao {

	private Connection con;
	
	// Constructor
	public PostDao(Connection con) {
		this.con = con;
	}
	
	// Save post in database
	public boolean SavePost(Post post) {

		boolean postSave = false;
		
		try {
			String q = "insert into posts(pContent,pPic,uId) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, post.getpContent());
			ps.setString(2, post.getpPic());
			ps.setInt(3, post.getuId());
			ps.executeUpdate();
			postSave = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return postSave;
	}


	// Getting All posts
	public List<Post> getAllPost() {
		
		List<Post> list = new ArrayList<>();
		try {
			// Fetching all the post
			PreparedStatement ps = con.prepareStatement("select * from posts");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int pId = rs.getInt("pId");
				String pContent = rs.getString("pContent");
				String pPic = rs.getString("pPic");
				Timestamp dateTime = rs.getTimestamp("pDate");
				int uId = rs.getInt("uId");
				Post post = new Post(pId, pContent, pPic, dateTime, uId);
				
				list.add(post);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	// Getting All posts By current-user
	public List<Post> getAllPostByCurrentUser(int uid) {

		List<Post> list = new ArrayList<>();
		try {
			// Fetching all the post
			PreparedStatement ps = con.prepareStatement("select * from posts where uId='"+uid+"'");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pId = rs.getInt("pId");
				String pContent = rs.getString("pContent");
				String pPic = rs.getString("pPic");
				Timestamp dateTime = rs.getTimestamp("pDate");
				int uId = rs.getInt("uId");
				Post post = new Post(pId, pContent, pPic, dateTime, uId);

				list.add(post);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
