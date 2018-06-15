package com.payments.controller;

import com.payments.config.TestRestConfig;
import com.payments.model.DataJson;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.payments.model.DataJsonBuilder.dataJsonBuilder;
import static com.payments.util.IntegrationTestHelper.apiUrl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.RequestEntity.get;
import static org.springframework.http.RequestEntity.post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestRestConfig.class)
public class PaymentControllerListITest {

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
    public void shouldListPaymentData() {
        DataJson dataJson = dataJsonBuilder().build();
        restTemplate.exchange(post(apiUrl("/v1/payments", port)).body(dataJson), DataJson.class);

        DataJson dataJson2 = dataJsonBuilder().build();
        restTemplate.exchange(post(apiUrl("/v1/payments", port)).body(dataJson2), DataJson.class);

        ResponseEntity<List<DataJson>> response = restTemplate.exchange(
                get(apiUrl("/v1/payments", port)).build(), new ParameterizedTypeReference<List<DataJson>>() {});

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(2);

        int dataCount = jdbcTemplate.queryForObject("SELECT count(*) FROM payment_data", int.class);
        assertThat(dataCount).isEqualTo(2);
        dataCount  = jdbcTemplate.queryForObject("SELECT count(*) FROM sender_charges_amount", int.class);
        assertThat(dataCount).isEqualTo(2);
    }
}
