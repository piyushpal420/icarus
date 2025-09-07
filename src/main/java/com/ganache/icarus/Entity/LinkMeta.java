package com.ganache.icarus.Entity;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder@Data
public class LinkMeta {
    @SerializedName("payment_methods")
    private String paymentMethods;

    @SerializedName("upi_intent")
    private String upiIntent;

    @SerializedName("return_url")
    private String returnUrl;

    @SerializedName("notify_url")
    private String notifyUrl;
}
