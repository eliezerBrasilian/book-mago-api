package com.app.controllers;

import com.app.entities.CambioEntity;
import com.app.records.Cambio;
import com.app.services.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private CambioService cambioService;

    @PostMapping("insert")
    public String insertDefaultCambios() {
        return cambioService.insertDefaultCambios();
    }

    @GetMapping("{quantity}/{from_currency}/{to_currency}")
    public Cambio getCambio(
            @PathVariable(value = "quantity") String quantity,
            @PathVariable(value = "from_currency") String fromCurrency,
            @PathVariable(value = "to_currency") String toCurrency
    ) {
        return cambioService.getCambio(quantity, fromCurrency, toCurrency);
    }

    @GetMapping("list")
    public List<CambioEntity> getCambios() {
        return cambioService.getCambios();
    }
}
