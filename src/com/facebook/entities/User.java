package com.facebook.entities;

public class User {
	
	//Fields 
	private int userId;
	private String fName;
	private String surName;
	private String email;
	private String password;
	private String dateOfBirth;
	private String gender;

	private String profilePic;
	private String status;

	// default constructor
	public User() {
		super();
	}

	// parameter constructor without userId
	public User(String fName, String surName, String email, String password, String dateOfBirth, String gender,
			 String profilePic,String status) {
		super();
		this.fName = fName;
		this.surName = surName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.profilePic = profilePic;
		this.status = status;
	}

	// setters & getters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//toString() method
	@Override
	public String toString() {
		return "User [fName=" + fName + ", surName=" + surName + ", email=" + email + ", password=" + password
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", profilePic=" + profilePic + ", status="
				+ status + "]";
	}

}
