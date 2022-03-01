package com.ms.email.adapters.outbound.smpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.application.domain.Email;
import com.ms.email.application.ports.SendEmailServicePort;

@Service
public class SmtpSendEmailService implements SendEmailServicePort {

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendEmailSmpt(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(email.getEmailFrom());
		message.setTo(email.getEmailTo());
		message.setSubject(email.getSubject());
		message.setText(email.getText());
		emailSender.send(message);
	}

}
