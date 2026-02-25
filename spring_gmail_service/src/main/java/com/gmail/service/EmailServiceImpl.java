package com.gmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmailWithAttachment(String to, String name, MultipartFile file) {

        try {

            // 1️⃣ Create MimeMessage
            MimeMessage message = mailSender.createMimeMessage();

            // 2️⃣ true → enables attachment
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true);

            // 3️⃣ Set basic details
            helper.setTo(to);
            helper.setSubject("Welcome to Spring MVC");
            helper.setText("Hello " + name + ", file is attached.");
            helper.setFrom("vikashkumarsharma56516@gmail.com");

            // 4️⃣ Attach uploaded file
            helper.addAttachment(
                    file.getOriginalFilename(),
                    file
            );

            // 5️⃣ Send email
            mailSender.send(message);

            System.out.println("Email with attachment sent successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void sendEmail(String to, String name) {
		// TODO Auto-generated method stub
		
	}
}