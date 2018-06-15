package com.payments.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;
import java.util.UUID;

@ApiModel("Data")
public final class DataJson {

    @ApiModelProperty(notes = "Type", readOnly = true)
    private final String type;

    @ApiModelProperty(notes = "Data ID", readOnly = true)
    private final UUID id;

    @ApiModelProperty(notes = "Version ID", readOnly = true)
    private final Integer version;

    @ApiModelProperty(notes = "Organisation ID", readOnly = true)
    private final UUID organisationId;

    @ApiModelProperty(notes = "Attributes")
    private final AttributesJson attributes;

    @JsonCreator
    public DataJson(final String type, final UUID id, final Integer version, final UUID organisationId,
                    final AttributesJson attributes) {
        this.type = type;
        this.id = id;
        this.version = version;
        this.organisationId = organisationId;
        this.attributes = attributes;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getVersion() {
        return version;
    }

    public UUID getOrganisationId() {
        return organisationId;
    }

    public AttributesJson getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DataJson dataJson = (DataJson) o;
        return Objects.equals(type, dataJson.type) &&
                Objects.equals(id, dataJson.id) &&
                Objects.equals(version, dataJson.version) &&
                Objects.equals(organisationId, dataJson.organisationId) &&
                Objects.equals(attributes, dataJson.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, version, organisationId, attributes);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .add("id", id)
                .add("version", version)
                .add("organisationId", organisationId)
                .add("attributes", attributes)
                .toString();
    }
}