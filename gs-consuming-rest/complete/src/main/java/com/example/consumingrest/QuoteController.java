package com.example.consumingrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class QuoteController {

  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/api/random")
  public Quote randomQuote() {
    long id = counter.incrementAndGet();
    Value value = new Value(id, "Nothing is impossible, the word itself says 'I'm possible'!");
    return new Quote("success", value);
  }
}
