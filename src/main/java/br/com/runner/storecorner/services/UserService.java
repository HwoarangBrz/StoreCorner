package br.com.runner.storecorner.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.runner.storecorner.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
