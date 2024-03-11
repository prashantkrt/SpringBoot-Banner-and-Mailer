package com.myLearning.springBoot.mailer.service;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrder {

	@Autowired
	private JavaMailSender sender;
	
	@Value("{spring.mail.username}")
	private String fromId;

	@Override
	public String purchase(String[] items, Double[] price, String[] toEmail) throws Exception {

		Double totalAmount = 0.0;
		for (Double p : price) {
			totalAmount += p;
		}

		String message = "Hello! " + Arrays.toString(items) + " with price " + Arrays.toString(price)
				+ " which is costing total of : " + totalAmount + " Bill attacked for reference";

		MimeMessage mimeMessage = sender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		helper.setTo("your mail");
		helper.setFrom(fromId);
		helper.setCc(toEmail);
		helper.setSubject("Attention");
		helper.setSentDate(new Date());
		helper.addAttachment("pinkPanther.jpeg", new ClassPathResource("pinkPanther.jpeg"));
		helper.setText(message);
		
		sender.send(mimeMessage);
	

		return "Mail sent Kindly check the mail id";
	}

}
