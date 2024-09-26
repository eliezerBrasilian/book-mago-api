package com.app.records;

import java.util.Date;

public record Book(
        String id,
        String author,
        Date launchDate,
        Double price,
        String title,
        String currency,
        String environment
) {
}
