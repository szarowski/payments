package com.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * The Payments Application class
 */
@EnableFeignClients
@SpringBootApplication
public class PaymentsApp extends SpringApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PaymentsApp.class, args);
    }
}