package com.ms.email.application.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ms.email.application.domain.Email;
import com.ms.email.application.domain.PageInfo;

public interface EmailRepositoryPort {

	Email save(Email emailModel);

	List<Email> findAll(PageInfo pageInfo);

	Optional<Email> findById(UUID emailId);
}
