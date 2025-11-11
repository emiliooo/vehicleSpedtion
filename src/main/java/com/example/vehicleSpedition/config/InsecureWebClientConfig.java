package com.example.vehicleSpedition.config;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class InsecureWebClientConfig {

    @Bean
    public WebClient insecureWebClient(WebClient.Builder builder) throws Exception {
        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE) // 💥 akceptuje każdy certyfikat
                .build();

        HttpClient httpClient = HttpClient.create()
                .secure(ssl -> ssl.sslContext(sslContext));

        return builder
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl("https://api.nbp.pl")
                .build();
    }
}
