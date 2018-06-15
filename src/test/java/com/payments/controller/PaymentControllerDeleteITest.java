package com.payments.controller;

import com.payments.config.TestRestConfig;
import com.payments.error.model.Errors;
import com.payments.model.DataJson;
import com.payments.util.Random;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static com.payments.model.DataJsonBuilder.dataJsonBuilder;
import static com.payments.util.IntegrationTestHelper.apiUrl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.RequestEntity.delete;
import static org.springframework.http.RequestEntity.post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestRestConfig.class)
public class PaymentControllerDeleteITest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @After
    public void wipeDb() {
        jdbcTemplate.update("DELETE FROM sender_charges_amount");
        jdbcTemplate.update("DELETE FROM payment_data");
    }

    @Test
    public void shouldDeletePaymentData() {
        DataJson dataJson = dataJsonBuilder().build();

        restTemplate.exchange(post(apiUrl("/v1/payments", port)).body(dataJson), DataJson.class);

        ResponseEntity<Void> response = restTemplate.exchange(
                delete(apiUrl("/v1/payments/" + dataJson.getId(), port)).build(), Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(response.getBody()).isNull();

        int dataCount = jdbcTemplate.queryForObject(
                "SELECT count(*) FROM payment_data WHERE id = ?", int.class, dataJson.getId());
        assertThat(dataCount).isEqualTo(0);
        dataCount  = jdbcTemplate.queryForObject(
                "SELECT count(*) FROM sender_charges_amount WHERE id = ?", int.class, dataJson.getId());
        assertThat(dataCount).isEqualTo(0);
    }

    @Test
    public void shouldReturn404ForNotFound() {
        ResponseEntity<Errors> response = restTemplate.exchange(
                delete(apiUrl("/v1/payments/" + Random.uuid(), port)).build(), Errors.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}