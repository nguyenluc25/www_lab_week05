package vn.edu.iuh.nguyentheluc_21046661_week05.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public String sendEmail(String recipients, String subject, String content) throws MessagingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("nguyenluctest1234012@gmail.com");
        helper.setTo(recipients);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
        return "Sent";
    }
}
