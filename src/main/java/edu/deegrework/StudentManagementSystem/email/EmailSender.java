package edu.deegrework.StudentManagementSystem.email;

public interface EmailSender {
    void sendMail(String from, String to, String subject, String content);
}
