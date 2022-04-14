package com.heyorange.heyorange.controller.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heyorange.heyorange.domain.vo.EmailVO;

@RestController
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/email")
	public HttpStatus enviarEmaill(EmailVO emailVO) throws MessagingException {
		MimeMessage mail = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mail);
		helper.setTo(emailVO.getPara());
		helper.setSubject(emailVO.getSubject());
		helper.setText("<p>" + emailVO.getTexto() + "</p>", true);
		mailSender.send(mail);

		return HttpStatus.OK;

	}
}
