package com.app.proxy;

import com.app.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cambio-service", url = "localhost:8001")
public interface CambioProxy {
    @GetMapping("cambio-service/{quantity}/{from_currency}/{to_currency}")
     Cambio getCambio(
            @PathVariable(value = "quantity") String quantity,
            @PathVariable(value = "from_currency") String fromCurrency,
            @PathVariable(value = "to_currency") String toCurrency
    );
}
