package br.com.runner.storecorner.dto;

import java.io.Serializable;

public class CredentialsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String pasword;
	
	public CredentialsDTO() {
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return pasword;
	}
	public void setPassword(String password) {
		this.pasword = password;
	}
}
