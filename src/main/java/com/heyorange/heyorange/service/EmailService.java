package com.heyorange.heyorange.service;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.configuration.FeaturesEmailConfiguration;
import com.heyorange.heyorange.domain.entity.EnvioEmail;
import com.heyorange.heyorange.exception.ServerException;
import com.heyorange.heyorange.repository.EnvioEmailRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailService implements FeaturesEmailConfiguration {

	@Autowired
	private EnvioEmailRepository envioEmailRepository;

	public void enviarEmailsPendentes() throws ServerException {
		List<EnvioEmail> emails = envioEmailRepository.findAll();
		if (!verificarConexao()) {
			throw new ServerException();
		}

		for (EnvioEmail email : emails) {
			if (email.getNumeroTentativas() < NUMERO_TENTATIVAS) {
				envioEmailRepository.save(enviarEmail(email));
			}
		}
	}

	private EnvioEmail enviarEmail(EnvioEmail email) {
		email.setNumeroTentativas(email.getNumeroTentativas() + 1);
		// TODO - codigo envio email
		
		return email;
	}

	@Override
	public boolean verificarConexao() {
		try {
			final URL url = new URL(URL);
			final URLConnection conn = url.openConnection();
			conn.connect();
			conn.getInputStream().close();
			
			return true;
		} catch (Exception e) {

			log.error(e.getMessage(), e.getLocalizedMessage());
			
			return false;
		}
	}
}
