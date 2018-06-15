package com.payments.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel("Links")
public final class LinksJson {

    @ApiModelProperty(notes = "Self link")
    private final String self;

    @JsonCreator
    public LinksJson(final String self) {
        this.self = self;
    }

    public String getSelf() {
        return self;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LinksJson linksJson = (LinksJson) o;
        return Objects.equals(self, linksJson.self);
    }

    @Override
    public int hashCode() {
        return Objects.hash(self);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("self", self)
                .toString();
    }
}