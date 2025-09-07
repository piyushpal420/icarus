package com.ganache.icarus.Entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class LinkNotify
{
    @SerializedName("send_email")
    private boolean sendEmail;

    @SerializedName("send_sms")
    private boolean sendSms;
}
