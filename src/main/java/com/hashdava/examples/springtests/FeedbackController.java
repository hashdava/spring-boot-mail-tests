package com.hashdava.examples.springtests;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private EmailCfg emailCfg;

	@PostMapping
	public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException("Feedback is not valid");
		}

		// Create a mail sender
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(this.emailCfg.getHost());
		mailSenderImpl.setPort(this.emailCfg.getPort());
		mailSenderImpl.setUsername(this.emailCfg.getUsername());
		mailSenderImpl.setPassword(this.emailCfg.getPassword());

		// Create an email instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(feedback.getEmail());
		mailMessage.setTo("rc@feedback.com");
		mailMessage.setSubject("New feedback from " + feedback.getName());
		mailMessage.setText(feedback.getFeedback());

		// Send mail
		mailSenderImpl.send(mailMessage);
	}
}
