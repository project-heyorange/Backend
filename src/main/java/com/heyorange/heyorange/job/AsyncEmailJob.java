package com.heyorange.heyorange.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.heyorange.heyorange.exception.ServerException;
import com.heyorange.heyorange.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableScheduling
@Slf4j
public class AsyncEmailJob {

	@Autowired
	private EmailService emailService;

	@Scheduled(cron = "0 0/10 * * * *")
	private void envioEmail() {
		try {
			emailService.enviarEmailsPendentes();
		} catch (ServerException e) {
			log.error(e.getMessage(), e.getLocalizedMessage());
		}

		log.info("Enviando e-mails de confirmação ...");
	}

}
