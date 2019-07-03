package br.com.runner.storecorner.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import br.com.runner.storecorner.domain.Client;
import br.com.runner.storecorner.domain.Order;

public class MockEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}
	
	@Override
	public void sendOrderConfirmationEmail(Order obj) {
		LOG.info("Confirmação de pedido...");
		LOG.info(obj.toString());
		LOG.info("Email enviado");
	}
	
	@Override
	public void sendNewPasswordEmail(Client client, String newPass) {
		LOG.info("Nova senha...");
		LOG.info("Usuário: " + client.getName() + " - Password: " + newPass);
		LOG.info("Email enviado");
	}
}
