package it.favo.antopao.booklibrary.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO {

	@NotBlank(message = "firstName is mandatory")
	private String firstName;

	@NotBlank(message = "lastName is mandatory")
	private String lastName;

	@NotBlank(message = "username is mandatory")
	private String username;

	@NotBlank(message = "password is mandatory")
	private String password;

	@NotBlank(message = "email is mandatory")
	private String email;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
