package com.example.vehicleSpedition.controller;
import com.example.vehicleSpedition.dto.CurrencyInfo;
import com.example.vehicleSpedition.service.CurrencyRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/secure")
public class CurrencyController {

    private CurrencyRateService currencyRateService;

    public CurrencyController(CurrencyRateService currencyRateService) {
            this.currencyRateService = currencyRateService;
    }

    @GetMapping("/currency")
    public Mono<CurrencyInfo> getCurrency() {
        return this.currencyRateService.getEurRate();
    }
}
