package com.payments.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;

import java.util.List;
import java.util.Objects;

public final class PaymentsJson {

    private final List<DataJson> data;

    private final LinksJson links;

    @JsonCreator
    public PaymentsJson(final List<DataJson> data, final LinksJson links) {
        this.data = data;
        this.links = links;
    }

    public List<DataJson> getData() {
        return data;
    }

    public LinksJson getLinks() {
        return links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PaymentsJson that = (PaymentsJson) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(links, that.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("data", data)
                .add("links", links)
                .toString();
    }
}