package com.app.response;

public record Cambio(
        String id,
        String from,
        String to,
        Double conversionFactor,
        Double convertedValue,
        String environment
) {

}