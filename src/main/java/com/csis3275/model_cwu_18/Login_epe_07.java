package com.csis3275.model_cwu_18;

/**
 * 
 * @author Eduardo Peres - 300318007
 * This is the login model, with email and password string variables.
 * Once the user opens the webapp, he goes to a login page where credentials such as email and password are required.
 * If the user does not have an account, there is a link that he gets redirrected to a page to create an account.
 * After pushing the credentials, the webapp will check with the database if the email and password are correct and will log in the user.
 * Therer are three types of differente users, student, faculty and admin. Admin gets redirrected to an admin features page while student and faculty
 * gets redirrected to a booking features page.
 * If the credentials punched in are incorrect, the user will be prompted with a message telling him that the credentials are wrong, to try again.
 *
 */

public class Login_epe_07 {
	
	//email will be the user credential for login
	private String email;
	private String password;
	
	
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
	public Login_epe_07(String newEmail, String newPassword) {
		super();
		this.email = newEmail;
		this.password = newPassword;
	}	

	public Login_epe_07() {}
}
