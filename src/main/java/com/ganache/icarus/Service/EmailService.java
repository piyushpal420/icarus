package com.ganache.icarus.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Async
    public void sendWelcomeMail(String email){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            String subject = "Welcome to Our Service!";
            String body = """
                <html>
                  <body style="font-family: Arial, sans-serif; background-color: #f7f7f7; padding: 20px;">
                    <div style="max-width: 600px; margin: auto; background: white; padding: 20px; border-radius: 10px;">
                      <h2 style="color: #333;">Hello!</h2>
                      <p style="font-size: 16px; color: #555;">
                        We're excited to have you with us at Ahvaan🚀<br><br>
                        If you have any questions, feel free to reply to this email.<br><br>
                        Cheers,<br>
                        <strong>The Team</strong>
                      </p>
                      <hr style="border: none; border-top: 1px solid #eee; margin: 20px 0;">
                      <small style="color: #aaa;">Please do not reply to this automated email.</small>
                    </div>
                  </body>
                </html>
                """;
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(body, true); // true means send HTML
            mailSender.send(mimeMessage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



}
