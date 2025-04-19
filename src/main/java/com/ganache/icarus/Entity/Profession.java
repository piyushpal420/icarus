package com.ganache.icarus.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum Profession {
    Student,
    GovernmentEmployee,
    PrivateEmployee,
    Businessman,
    SelfEmployed,
    HomeMaker,
    Retired,
    Unemployed,
    Other;
    @JsonCreator
    public static Profession fromString(String key) {
        return Arrays.stream(Profession.values())
                .filter(p -> p.name().equalsIgnoreCase(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid value for Profession: " + key));
    }
}

