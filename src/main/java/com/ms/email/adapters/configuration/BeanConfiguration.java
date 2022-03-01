package com.ms.email.adapters.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ms.email.MsEmailApplication;
import com.ms.email.application.ports.EmailRepositoryPort;
import com.ms.email.application.ports.SendEmailServicePort;
import com.ms.email.application.services.EmailServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = MsEmailApplication.class)
public class BeanConfiguration {

	@Bean
	EmailServiceImpl emailServiceImpl(EmailRepositoryPort repository, SendEmailServicePort sendEmailServicePort) {
		return new EmailServiceImpl(repository, sendEmailServicePort);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
