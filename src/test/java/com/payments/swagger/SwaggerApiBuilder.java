package com.payments.swagger;

import com.payments.util.Random;

import java.util.List;

public final class SwaggerApiBuilder {

    private boolean internal = Random.bool();
    private String basePath = Random.string();
    private List<String> excludedPaths = Random.list(Random.string());

    private SwaggerApiBuilder() {
    }

    public static SwaggerApiBuilder swaggerApiBuilder() {
        return new SwaggerApiBuilder();
    }

    public SwaggerApiBuilder internal(boolean internal) {
        this.internal = internal;
        return this;
    }

    public SwaggerApiBuilder basePath(String basePath) {
        this.basePath = basePath;
        return this;
    }

    public SwaggerApiBuilder excludedPaths(List<String> excludedPaths) {
        this.excludedPaths = excludedPaths;
        return this;
    }

    public SwaggerApi build() {
        return new SwaggerApi(internal, basePath, excludedPaths);
    }
}
