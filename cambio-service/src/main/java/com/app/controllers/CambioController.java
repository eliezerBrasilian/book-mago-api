package com.app.controllers;

import com.app.records.Cambio;
import com.app.services.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private CambioService cambioService;

    @GetMapping("{quantity}/{from_currency}/{to_currency}")
    public Cambio getCambio(
            @PathVariable(value = "quantity") String quantity,
            @PathVariable(value = "from_currency") String fromCurrency,
            @PathVariable(value = "to_currency") String toCurrency
    ) {
        return cambioService.getCambio(quantity, fromCurrency, toCurrency);
    }
}
