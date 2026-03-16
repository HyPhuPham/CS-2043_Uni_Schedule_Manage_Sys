 package com.university.app.model;

/**
 * This class represent the user model entities
 * 
 * @author Mariyah Antony
 * @verion 1.1
 * @since 2025-11-06
 */

public class UserModel {
	private long id;
	private String user_name;
	private String Password;

	
	public UserModel(long id, String user_name, String password) {
		this.id = id;
		this.user_name = user_name;
		this.Password = password;

	}
	
	public long getId() {
		return id;
	}
	

	public String getUsername() {
		return user_name;
	}
	

	public String getPassword() {
		return Password;
	}

	
	public boolean CheckLogin(String User_Name, String Password) {
		boolean correctinfo = false;
		if (User_Name == this.user_name && Password == this.Password) {
			correctinfo = true;
		}
		return correctinfo;
	}
	public boolean ChangePassword(String User_Name, String Password, String NewPassword) {
		boolean correctlogin = CheckLogin(User_Name, Password);
		boolean changed = false;
		if (correctlogin) {
			this.Password = NewPassword;
			changed = true;
		}
		return changed;
	}
}



