package com.example.getReq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class ConsumingRestApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Component
    public static class DataInitializer {

        private final RestTemplate restTemplate;
        private final ProductRepository productRepository;
        private final CategoryRepository categoryRepository;
        private final UserTypeRepository userTypeRepository;
        private final ObjectMapper objectMapper;

        public DataInitializer(
                RestTemplate restTemplate,
                ProductRepository productRepository,
                CategoryRepository categoryRepository,
                UserTypeRepository userTypeRepository,
                ObjectMapper objectMapper) {
            this.restTemplate = restTemplate;
            this.productRepository = productRepository;
            this.categoryRepository = categoryRepository;
            this.userTypeRepository = userTypeRepository;
            this.objectMapper = objectMapper;
        }

        @Bean
        public CommandLineRunner run() {
            return args -> {
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        "https://automationexercise.com/api/productsList",
                        HttpMethod.GET,
                        new HttpEntity<>(headers),
                        String.class);

                if (responseEntity.getStatusCode() == HttpStatus.OK) {
                    String responseBody = responseEntity.getBody();

                    try {
                        Items items = objectMapper.readValue(responseBody, Items.class);

                        for (Product product : items.getProducts()) {
                            Category savedCategory = categoryRepository.save(product.getCategory());

                            product.setCategory(savedCategory);

                            productRepository.save(product);
                            log.info(product.toString());
                        }

                    } catch (JsonProcessingException e) {
                        log.error("Error parsing JSON response: {}", e.getMessage());
                    }
                } else {
                    log.error("Received non-OK status from the API: {}", responseEntity.getStatusCode());
                }
            };
        }
    }
}
