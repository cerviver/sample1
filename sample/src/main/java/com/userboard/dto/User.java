package com.userboard.dto;

import java.util.Date;

/*
	user_no	INT	NOT NULL AUTO_INCREMENT,
	user_id	VARCHAR(50)	NOT NULL,
	user_password	VARCHAR(100) NOT NULL,
	user_name	VARCHAR(30) NOT NULL,
	user_email	VARCHAR(50) NOT NULL,
	user_address	VARCHAR(1000) NOT NULL,
	user_phone	VARCHAR(50) NOT NULL,
	user_date	DATETIME NOT NULL,
	user_grade	INT,
 */

public class User {
	
	private int userNo;
	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userAddress;
	private String userPhone;
	private Date userDate;
	private int userGrade;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userNo, String userId, String userPassword, String userName, String userEmail, String userAddress,
			String userPhone, Date userDate, int userGrade) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.userDate = userDate;
		this.userGrade = userGrade;
	}

	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public Date getUserDate() {
		return userDate;
	}


	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}


	public int getUserGrade() {
		return userGrade;
	}


	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
	

}
