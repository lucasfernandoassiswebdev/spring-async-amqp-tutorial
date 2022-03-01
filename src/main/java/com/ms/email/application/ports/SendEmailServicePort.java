package com.ms.email.application.ports;

import com.ms.email.application.domain.Email;

public interface SendEmailServicePort {

	void sendEmailSmpt(Email email);
}
