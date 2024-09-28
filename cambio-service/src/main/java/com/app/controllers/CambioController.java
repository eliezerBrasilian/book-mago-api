package com.app.controllers;

import com.app.entities.CambioEntity;
import com.app.records.Cambio;
import com.app.services.CambioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private CambioService cambioService;

    @Operation(summary = "Insere câmbios padrões", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inserção realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Chave de API inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar inserção dos câmbios")
    })
    @Parameter(
            name = "X-API-KEY",
            description = "Chave de API necessária para realizar a inserção dos câmbios",
            required = true,
            in = ParameterIn.HEADER
    )
    @PostMapping("insert")
    public String insertDefaultCambios() {
        return cambioService.insertDefaultCambios();
    }

    @Operation(summary = "Realiza a conversão cambial entre duas moedas, com base na quantidade desejada", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conversão realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a conversão"),
    })
    @GetMapping("{quantity}/{from_currency}/{to_currency}")
    public Cambio getCambio(
            @PathVariable(value = "quantity") String quantity,
            @PathVariable(value = "from_currency") String fromCurrency,
            @PathVariable(value = "to_currency") String toCurrency
    ) {
        return cambioService.getCambio(quantity, fromCurrency, toCurrency);
    }

    @Operation(summary = "Busca todos os câmbios", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos câmbios"),
    })
    @GetMapping("list")
    public List<CambioEntity> getCambios() {
        return cambioService.getCambios();
    }
}
