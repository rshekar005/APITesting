package com.mfino.data;

public class Users {

	String userName;
	String userJob;
	String id;
	String createddate;
	
	public Users(String username, String userjob)
	{
		this.userName= username;
		this.userJob= userjob;	
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserJob() {
		return userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}


}
