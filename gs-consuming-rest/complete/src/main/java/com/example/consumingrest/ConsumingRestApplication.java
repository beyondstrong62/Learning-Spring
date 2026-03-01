package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;
import java.util.Objects;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class ConsumingRestApplication {

  private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ConsumingRestApplication.class, args);
  }

  // Run after the application is ready (and the embedded web server has started) so
  // calls to the app's own endpoints succeed. This replaces the previous ApplicationRunner
  // which could attempt the HTTP call before the server was bound.
  @Bean
  @Profile("!test")
  public ApplicationListener<ApplicationReadyEvent> onReady(RestClient.Builder builder,
                                                           @Value("${quote.service.base-url:http://localhost:8081}") String quoteServiceBaseUrl,
                                                           @Value("${quote.fetch.enabled:true}") boolean quoteFetchEnabled) {
    return event -> {
      if (!quoteFetchEnabled) {
        log.info("Quote fetching at startup is disabled (quote.fetch.enabled=false)");
        return;
      }

      RestClient restClient = builder.baseUrl(quoteServiceBaseUrl).build();
      final String targetUri = quoteServiceBaseUrl + "/api/random";
      try {
        Quote quote = restClient
            .get().uri("/api/random")
            .retrieve()
            .body(Quote.class);
        log.info(Objects.toString(quote, "<no-quote>"));
      } catch (Exception ex) {
        // Don't fail application startup if the remote service is unavailable.
        log.warn("Could not retrieve quote from {} - continuing without it", targetUri, ex);
      }
    };
  }
}
