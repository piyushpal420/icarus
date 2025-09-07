package com.ganache.icarus.Service;
import com.cashfree.pg.Cashfree;

import com.cashfree.pg.model.LinkMetaResponseEntity;
import com.ganache.icarus.Entity.PaymentLink;
import com.ganache.icarus.Entity.PaymentResponse;
import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

@Service
public class PaymentService
{

    private static final String clientId = "TEST10557584db3ac22020b0c97b958a48575501";
    private static final String clientSecret = "cfsk_ma_test_e5fab69e943f6e50493d51a9a886e8dc_49bca0f7";
    private static final String apiLink = "https://sandbox.cashfree.com/pg/links";
    private static final String apiVersion = "2025-01-01";

    public String createPaymentLink(PaymentLink paymentLink) {
        try {
            Gson gson = new Gson();
            String jsonBody = gson.toJson(paymentLink);

            HttpResponse<String> response = Unirest.post(apiLink)
                    .header("x-client-id", clientId)
                    .header("x-client-secret", clientSecret)
                    .header("x-api-version", apiVersion)
                    .header("Content-Type", "application/json")
                    .body(jsonBody)
                    .asString();

            if (response.getStatus() == 200) {
                // Deserialize the JSON response to PaymentLinkResponse
                PaymentResponse paymentLinkResponse = gson.fromJson(response.getBody(), PaymentResponse.class);

                // Return the link_url (payment link)
                return paymentLinkResponse.getLinkUrl();
            } else {
                // Handle error response
                response.getBody();
            }

        } catch (Exception e) {
            System.err.println("Exception while creating payment link: " + e.getMessage());
            return null;
        }
        return null;
    }
}
