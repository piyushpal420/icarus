package com.ganache.icarus.Entity;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class PaymentResponse {

    @SerializedName("cf_link_id")
    private String cfLinkId;

    @SerializedName("customer_details")
    private CustomerDetail customerDetails;

    @SerializedName("enable_invoice")
    private boolean enableInvoice;

    @SerializedName("entity")
    private String entity;

    @SerializedName("link_amount")
    private double linkAmount;

    @SerializedName("link_amount_paid")
    private double linkAmountPaid;

    @SerializedName("link_auto_reminders")
    private boolean linkAutoReminders;

    @SerializedName("link_created_at")
    private String linkCreatedAt;

    @SerializedName("link_currency")
    private String linkCurrency;

    @SerializedName("link_expiry_time")
    private String linkExpiryTime;

    @SerializedName("link_id")
    private String linkId;

    @SerializedName("link_meta")
    private LinkMeta linkMeta;

    @SerializedName("link_minimum_partial_amount")
    private Double linkMinimumPartialAmount;

    @SerializedName("link_notes")
    private LinkNotes linkNotes;

    @SerializedName("link_notify")
    private LinkNotify linkNotify;

    @SerializedName("link_partial_payments")
    private boolean linkPartialPayments;

    @SerializedName("link_purpose")
    private String linkPurpose;

    @SerializedName("link_qrcode")
    private String linkQrCode;

    @SerializedName("link_status")
    private String linkStatus;

    @SerializedName("link_url")
    private String linkUrl;

    @SerializedName("order_splits")
    private List<Object> orderSplits;

    @SerializedName("terms_and_conditions")
    private String termsAndConditions;

    @SerializedName("thank_you_msg")
    private String thankYouMsg;


}

