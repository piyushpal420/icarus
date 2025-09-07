package com.ganache.icarus.Entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class LinkNotes {
    @SerializedName("user_id")
    private String userId;

    @SerializedName("invoice")
    private String invoice;
}
