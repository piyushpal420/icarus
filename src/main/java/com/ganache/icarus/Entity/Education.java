package com.ganache.icarus.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum Education {
    Illiterate,
    Matriculate,
    Intermediate,
    Graduate,
    Postgraduate,
    PhD,
    Other;
    @JsonCreator
    public static Education fromString(String value) {
        return Arrays.stream(Education.values())
                .filter(e -> e.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid value: " + value));
    }

}

