package br.com.runner.storecorner.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.runner.storecorner.domain.Client;
import br.com.runner.storecorner.domain.Order;

public interface EmailService {

	void sendOrderConfirmationEmail(Order obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Client client, String newPass);
}
