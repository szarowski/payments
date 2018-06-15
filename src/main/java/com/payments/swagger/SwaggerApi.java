package com.payments.swagger;

import com.google.common.base.MoreObjects;

import java.util.List;
import java.util.Objects;

public final class SwaggerApi {

    private final boolean internal;

    private final String basePath;

    private final List<String> excludedPaths;

    public SwaggerApi(final boolean internal, final String basePath, final List<String> excludedPaths) {
        this.internal = internal;
        this.basePath = basePath;
        this.excludedPaths = excludedPaths;
    }

    public boolean isInternal() {
        return internal;
    }

    public String getBasePath() {
        return basePath;
    }

    public List<String> getExcludedPaths() {
        return excludedPaths;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SwaggerApi that = (SwaggerApi) o;
        return internal == that.internal &&
                Objects.equals(basePath, that.basePath) &&
                Objects.equals(excludedPaths, that.excludedPaths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internal, basePath, excludedPaths);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("internal", internal)
                .add("basePath", basePath)
                .add("excludedPaths", excludedPaths)
                .toString();
    }
}