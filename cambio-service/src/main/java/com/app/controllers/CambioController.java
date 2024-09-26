package com.app.controllers;

import com.app.entities.CambioEntity;
import com.app.records.Cambio;
import com.app.repositories.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    Environment environment;

    @Autowired
    CambioRepository cambioRepository;


    @PostMapping
    public String insert() {
        var cambios = List.of(
                new CambioEntity("USD", "BRL", 5.80),
                new CambioEntity("USD", "QNZ", 23.52)
        );

        cambioRepository.saveAll(cambios);

        return "Isso aí";
    }

    @GetMapping("{quantity}/{from_currency}/{to_currency}")
    public Cambio getCambio(
            @PathVariable(value = "quantity") String quantity,
            @PathVariable(value = "from_currency") String fromCurrency,
            @PathVariable(value = "to_currency") String toCurrency
    ) {
        var port = environment.getProperty("local.server.port");

        var cambioEntity = cambioRepository.findByFromAndTo(fromCurrency, toCurrency)
                .orElseThrow();

        var quantityAsNumber = Double.parseDouble(quantity);

        var valueConverted = quantityAsNumber * cambioEntity.getConvertionFactor();

        return new Cambio(
                cambioEntity.getId(),
                fromCurrency,
                toCurrency,
                cambioEntity.getConvertionFactor(),
                valueConverted,
                port
        );
    }
}
