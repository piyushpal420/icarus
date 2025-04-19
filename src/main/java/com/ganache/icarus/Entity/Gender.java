package com.ganache.icarus.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum Gender
{
    Male,
    Female,
    Other;
    @JsonCreator
    public static Gender fromString(String key) {
        return Arrays.stream(Gender.values())
                .filter(g -> g.name().equalsIgnoreCase(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid value for Gender: " + key));
    }
}
