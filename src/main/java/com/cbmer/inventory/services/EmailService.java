package com.cbmer.inventory.services;

import org.springframework.mail.SimpleMailMessage;

import com.cbmer.inventory.domain.Cliente;
import com.cbmer.inventory.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
