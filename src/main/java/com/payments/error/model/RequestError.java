package com.payments.error.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * RequestError model
 */
@ApiModel
@JsonInclude(Include.NON_NULL)
public class RequestError {
    @ApiModelProperty(notes = "Error code")
    private final String code;
    @ApiModelProperty(notes = "Error message")
    private final String message;
    @ApiModelProperty(notes = "Field the error is related to (unless it's a general error)")
    private final String field;
    @ApiModelProperty(notes = "The type of error")
    private final String type;

    @JsonCreator
    public RequestError(final String code, final String message, final String field, final String type) {
        this.code = code;
        this.message = message;
        this.field = field;
        this.type = type;
    }

    public String getType() { return type; }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RequestError that = (RequestError) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(field, that.field) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, field, type);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("code", code)
                .add("message", message)
                .add("field", field)
                .add("type", type)
                .toString();
    }
}