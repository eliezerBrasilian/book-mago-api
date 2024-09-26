package com.app.records;

import java.math.BigDecimal;

public record Cambio(
        int id,
        String from,
        String to,
        BigDecimal conversionFactor,
        BigDecimal convertedValue,
        String environment
) {

}
