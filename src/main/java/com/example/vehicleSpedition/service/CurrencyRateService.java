package com.example.vehicleSpedition.service;
import com.example.vehicleSpedition.dto.CurrencyInfo;
import com.example.vehicleSpedition.dto.NBPDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.hibernate.Hibernate.map;

@Service
public class CurrencyRateService {


    private final WebClient webClient;

    // Wstrzykujemy WebClient z naszej konfiguracji
    public CurrencyRateService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getUSDRate(){
        return webClient.get()
                .uri("/api/exchangerates/rates/a/usd/?format=json")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<CurrencyInfo> getEurRate() {
        return webClient.get()
                .uri("/api/exchangerates/rates/a/eur/?format=json")
                .retrieve()
                .bodyToMono(NBPDto.class)
                .map(nbpresp -> {
                    var rate = nbpresp.getRates().get(0);
                    return new CurrencyInfo(
                            nbpresp.getCode(),
                            rate.getEffectiveDate(),
                            rate.getMid()
                    );
                }); // 👈 return przed całym wyrażeniem
    }
}
