package edu.deegrework.StudentManagementSystem.email.sendgrid;


import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendGridConfig {

    @Value("${sendgrid.api.key}")
    String sendGridAPIKey;

    @Bean
    public SendGrid sendGrid(){
        return new SendGrid(sendGridAPIKey);
    }


}
