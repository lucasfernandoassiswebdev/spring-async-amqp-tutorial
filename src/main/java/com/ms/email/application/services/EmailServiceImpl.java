package com.ms.email.application.services;

import com.ms.email.application.domain.Email;
import com.ms.email.application.domain.PageInfo;
import com.ms.email.application.domain.enums.StatusEmail;
import com.ms.email.application.ports.EmailRepositoryPort;
import com.ms.email.application.ports.EmailServicePort;
import com.ms.email.application.ports.SendEmailServicePort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.mail.MailException;

public class EmailServiceImpl implements EmailServicePort {

	private EmailRepositoryPort emailRepositoryPort;
	private SendEmailServicePort sendEmailServicePort;

	public EmailServiceImpl(EmailRepositoryPort emailRepositoryPort, SendEmailServicePort sendEmailServicePort) {
		this.emailRepositoryPort = emailRepositoryPort;
		this.sendEmailServicePort = sendEmailServicePort;
	}

	@SuppressWarnings("finally")
	public Email sendEmail(Email email) {
		email.setSendDateEmail(LocalDateTime.now());
		try {
			sendEmailServicePort.sendEmailSmpt(email);
			email.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			email.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return save(email);
		}
	}

	@Override
	public List<Email> findAll(PageInfo pageable) {
		return emailRepositoryPort.findAll(pageable);
	}

	@Override
	public Optional<Email> findById(UUID emailId) {
		return emailRepositoryPort.findById(emailId);
	}

	@Override
	public Email save(Email email) {
		return emailRepositoryPort.save(email);
	}
}
