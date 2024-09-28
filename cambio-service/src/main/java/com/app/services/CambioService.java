package com.app.services;

import com.app.entities.CambioEntity;
import com.app.records.Cambio;
import com.app.repositories.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String insertDefaultCambios() {
        var exchangeRates = List.of(
                new CambioEntity("BRL", "USD", 0.20),
                new CambioEntity("BRL", "AOA", 86.50),
                new CambioEntity("BRL", "VES", 35.20),
                new CambioEntity("BRL", "RUB", 18.00),
                new CambioEntity("BRL", "CNY", 1.47),
                new CambioEntity("BRL", "UYU", 7.69),
                new CambioEntity("BRL", "IDR", 3020.00),

                new CambioEntity("USD", "AOA", 432.50),
                new CambioEntity("USD", "VES", 176.00),
                new CambioEntity("USD", "RUB", 90.00),
                new CambioEntity("USD", "CNY", 7.35),
                new CambioEntity("USD", "UYU", 38.45),
                new CambioEntity("USD", "IDR", 15100.00),

                new CambioEntity("AOA", "VES", 0.41),
                new CambioEntity("AOA", "RUB", 0.21),
                new CambioEntity("AOA", "CNY", 0.017),
                new CambioEntity("AOA", "UYU", 0.09),
                new CambioEntity("AOA", "IDR", 34.85)
        );

        cambioRepository.saveAll(exchangeRates);

        return "inserted successfully";
    }

    public List<CambioEntity> getCambios() {
        return cambioRepository.findAll();
    }
}
