package com.techknow.ssv.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author JyotiSingh
 *
 */
public class User {
	private int userId;

	@NotNull(message = "First name must not be null")
	@Pattern(regexp = "^[a-zA-Z\\s]{2,10}+$", message = "First name must be letter of min length 2 and max length 10.")
	private String firstName;

	@NotNull(message = "Last name must not be null")
	@Pattern(regexp = "^[a-zA-Z\\s]{2,10}+$", message = "Last name must be letter of min length 2 and max length 10.")
	private String lastName;
	
	@Email
	@Size(min = 5, max = 40, message = "Email must be of min length 5 and max length 40.")
	private String email;
	
	@Pattern(regexp = "^[0-9]{10}+$", message = "Phone number must be digit of max length 10.")
	private String phone;
	
	@NotNull(message = "Password must not be null")
	@NotBlank(message = "Password must not be blank.")
	@Size(max = 16, min = 8)
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
