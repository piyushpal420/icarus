package com.ganache.icarus.Service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{
    String WelcomeBody = """
                <html>
                  <WelcomeBody style="font-family: Arial, sans-serif; background-color: #f7f7f7; padding: 20px;">
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
                  </WelcomeBody>
                </html>
                """;

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
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(WelcomeBody, true); // true means send HTML
            mailSender.send(mimeMessage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    @Async
    public void sendPaymentLinkMail(String email, String paymentLinkUrl) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(email);
            helper.setFrom("piyushpalgg26@gmail.com");
            helper.setSubject("MY ONLY FANS SUBSCRIPTION :D");

            String emailBody = "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<style>"
                    + "  body { font-family: Arial, sans-serif; background-color: #f8f9fa; padding: 20px; color: #333; }"
                    + "  .container { background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05); max-width: 600px; margin: auto; }"
                    + "  h3 { color: #2c3e50; }"
                    + "  p { font-size: 15px; line-height: 1.6; }"
                    + "  .button { display: inline-block; padding: 10px 20px; margin-top: 15px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 5px; font-weight: bold; }"
                    + "  .footer { margin-top: 30px; font-size: 13px; color: #777; }"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "  <div class='container'>"
                    + "    <h3>🙏 Thank you for choosing to donate!</h3>"
                    + "    <p>We truly appreciate your support. Your generosity helps us continue our mission at Ahvaan.</p>"
                    + "    <p>We’ve generated a secure payment link just for you:</p>"
                    + "    <a class='button' href='" + paymentLinkUrl + "' target='_blank'>Make Your Donation</a>"
                    + "    <p class='footer'>If you have any questions or need help, feel free to reply to this email.</p>"
                    + "  </div>"
                    + "</body>"
                    + "</html>";


            helper.setText("Click the link to donate: " + paymentLinkUrl, emailBody);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            System.err.println("Failed to send payment link email");
        }
    }

}
