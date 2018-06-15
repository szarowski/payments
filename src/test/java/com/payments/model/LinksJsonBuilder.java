package com.payments.model;

import com.payments.util.Random;

public final class LinksJsonBuilder {

    private String self = Random.url();

    private LinksJsonBuilder() {
    }

    public static LinksJsonBuilder linksJsonBuilder() {
        return new LinksJsonBuilder();
    }

    public LinksJsonBuilder self(String self) {
        this.self = self;
        return this;
    }

    public LinksJson build() {
        return new LinksJson(self);
    }
}
