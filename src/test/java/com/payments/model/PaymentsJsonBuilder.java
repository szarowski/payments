package com.payments.model;

import com.payments.util.Random;

import java.util.List;

import static com.payments.model.DataJsonBuilder.dataJsonBuilder;
import static com.payments.model.LinksJsonBuilder.linksJsonBuilder;

public final class PaymentsJsonBuilder {

    private List<DataJson> data = Random.list(dataJsonBuilder().build(), dataJsonBuilder().build());
    private LinksJson links = linksJsonBuilder().build();

    private PaymentsJsonBuilder() {
    }

    public static PaymentsJsonBuilder paymentsJsonBuilder() {
        return new PaymentsJsonBuilder();
    }

    public PaymentsJsonBuilder data(List<DataJson> data) {
        this.data = data;
        return this;
    }

    public PaymentsJsonBuilder links(LinksJson links) {
        this.links = links;
        return this;
    }

    public PaymentsJson build() {
        return new PaymentsJson(data, links);
    }
}