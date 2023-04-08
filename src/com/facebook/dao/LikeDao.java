package com.facebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class LikeDao {

	private Connection con;
	
	// Constructor
	public LikeDao(Connection con) {
		this.con = con;
	}
	
	//Save like in database
	public boolean insertLikes(int pid, int uid) {
		boolean save = false;
		
		try {
			
			String q = "insert into Likes(pid,uid) values(?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			//values set..
			ps.setInt(1, pid);
			ps.setInt(2, uid);
			ps.executeUpdate();
			
			save = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return save;
	}

	
	
	//Count post likes
	public int countLikeonPost(int pid) {
		int count=0;
		
		try {
			
			String q = "select count(*) from Likes where pid=?";
			PreparedStatement ps = con.prepareStatement(q);
			//set value
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	
	//Check user already post like or not
	public boolean isLikedByUser(int pid,int uid) {
		boolean isLiked = false;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from Likes where pid=? and uid=?");
			//set values
			ps.setInt(1, pid);
			ps.setInt(2, uid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				isLiked = true;
			
			
		}catch(Exception e) {e.printStackTrace();}
		
		
		return isLiked;
	}
	
	
	//Delete like in database
	public boolean deleteLike(int pid,int uid) {
		boolean isDelete = false;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("delete from Likes where pid=? and uid=?");
			//set values
			ps.setInt(1, pid);
			ps.setInt(2, uid);
			ps.executeUpdate();
			
			isDelete = true;
			
		}catch(Exception e) {e.printStackTrace();}
		
		
		return isDelete;
	}

	
	

}
