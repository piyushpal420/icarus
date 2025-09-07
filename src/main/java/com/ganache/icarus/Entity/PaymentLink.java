package com.ganache.icarus.Entity;

import com.cashfree.pg.model.LinkMetaResponseEntity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class PaymentLink {

    @SerializedName("customer_details")
    private CustomerDetail customerDetails;

    @SerializedName("link_notify")
    private LinkNotify linkNotify;

    @SerializedName("link_id")
    private String linkId;

    @SerializedName("link_amount")
    private double linkAmount;

    @SerializedName("link_currency")
    private String linkCurrency;

    @SerializedName("link_purpose")
    private String linkPurpose;

    @SerializedName("link_meta")
    private LinkMeta linkMeta;

    @SerializedName("link_notes")
    private LinkNotes linkNotes;

}
