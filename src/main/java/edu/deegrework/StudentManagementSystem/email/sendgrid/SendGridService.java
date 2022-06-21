package edu.deegrework.StudentManagementSystem.email.sendgrid;


import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGridAPI;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import edu.deegrework.StudentManagementSystem.email.EmailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class SendGridService implements EmailSender {

    private final SendGridAPI sendGridAPI;

    @Async
    public void sendMail(String from, String to, String subject, String content) {
        log.info("ActionLog.sendMail.start to: {}", to);
        Email f = new Email(from);
        Email t = new Email(to);
        Personalization personalization = new Personalization();
        personalization.addTo(t);
        Content c = new Content("text/plain", content);
        Mail mail = new Mail(f, subject, t, c);
        mail.setFrom(f);
        mail.addPersonalization(personalization);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGridAPI.api(request);
        } catch (IOException e) {
            log.error("ActionLog.sendMail.error sending mail to: {}", to);
            e.printStackTrace();
        }
        log.info("ActionLog.sendMail.start end: {}", to);
    }
}
