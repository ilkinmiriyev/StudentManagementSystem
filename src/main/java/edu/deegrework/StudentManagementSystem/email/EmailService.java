package edu.deegrework.StudentManagementSystem.email;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class EmailService{

    private final JavaMailSender mailSender;

    @Async
    public void sendMail(String from, String to,String subject, String content) {
        log.info("ActionLog.send.start sending mail to: {}", to);
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            log.error("ActionLog.send.error failed to send email to: {}", to);
            throw new IllegalStateException("failed to send email");
        }
        log.info("ActionLog.sendMail.start end: {}", to);
    }
}
