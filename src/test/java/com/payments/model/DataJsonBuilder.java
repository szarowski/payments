package com.payments.model;

import com.payments.util.Random;

import java.util.UUID;

import static com.payments.model.AttributesJsonBuilder.attributesJsonBuilder;

public final class DataJsonBuilder {

    private String type = Random.string();
    private UUID id = Random.uuid();
    private Integer version = Random.intVal();
    private UUID organisationId = Random.uuid();
    private AttributesJson attributes = attributesJsonBuilder().build();

    private DataJsonBuilder() {
    }

    public static DataJsonBuilder dataJsonBuilder() {
        return new DataJsonBuilder();
    }

    public DataJsonBuilder type(String type) {
        this.type = type;
        return this;
    }

    public DataJsonBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public DataJsonBuilder version(Integer version) {
        this.version = version;
        return this;
    }

    public DataJsonBuilder organisationId(UUID organisationId) {
        this.organisationId = organisationId;
        return this;
    }

    public DataJsonBuilder attributes(AttributesJson attributes) {
        this.attributes = attributes;
        return this;
    }

    public DataJson build() {
        return new DataJson(type, id, version, organisationId, attributes);
    }
}
