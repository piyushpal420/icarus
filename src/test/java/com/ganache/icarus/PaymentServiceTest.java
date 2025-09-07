package com.ganache.icarus;
import com.ganache.icarus.Entity.*;
import com.ganache.icarus.Service.EmailService;
import com.ganache.icarus.Service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class PaymentServiceTest
{

    @Autowired
    public PaymentService paymentService;
    @Autowired
    public EmailService emailService;

    public
    @Test
    void paymentLinkTest()
    {
        CustomerDetail c = CustomerDetail.builder()
                .customerEmail("piyushpal.recruitment@gmail.com")
                .customerPhone("8052205982")
                .customerName("Piyush").build();

        LinkNotes x = LinkNotes.builder()
                .userId("5")
                .invoice("32n2jn32").build();

        LinkNotify y = LinkNotify.builder()
                .sendSms(false).sendEmail(false).build();
        LinkMeta z = LinkMeta.builder().returnUrl("https://www.youtube.com/watch?v=g7-YWCqONkQ").build();

        PaymentLink paymentLink = PaymentLink.builder()
                .linkCurrency("INR")
                .linkNotify(y)
                .linkNotes(x)
                .linkMeta(z)
                .customerDetails(c)
                .linkAmount(100.00)
                .linkId("1234G")
                .linkPurpose("FOR MY ONLY FANS :)")
                .build();
        //paymentService.createPaymentLink(paymentLink);
        String link = paymentService.createPaymentLink(paymentLink);
        String email = "mishraadityakumar89@gmail.com";
        emailService.sendPaymentLinkMail(email, link);
    }
}
