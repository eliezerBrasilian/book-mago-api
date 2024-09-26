package com.app.services;

import com.app.records.Cambio;
import com.app.repositories.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CambioService {

    @Autowired
    Environment environment;

    @Autowired
    CambioRepository cambioRepository;


    public Cambio getCambio(String quantity,
                            String fromCurrency,
                            String toCurrency) {

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
