package com.payments.config;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;
import com.payments.error.model.Errors;
import com.payments.model.PaymentsJson;
import com.payments.swagger.SwaggerApi;
import com.payments.swagger.UniqueIdSetterPlugin;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newTreeMap;
import static springfox.documentation.builders.PathSelectors.ant;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * Swagger2 configuration for Spring
 */
@Configuration
@EnableSwagger2
@Import(value = BeanValidatorPluginsConfiguration.class)
@ConditionalOnClass(Docket.class)
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true")
public class SwaggerConfig {

    private static final String CHARS_TO_ESCAPE = "(?=[]\\[+&|!(){}^\"~*?:\\\\-])";

    @Autowired
    protected TypeResolver typeResolver;

    @Bean
    public SwaggerApi swaggerApiInternal() {
        return new SwaggerApi(true, "/v1/", null);
    }

    @Autowired
    public void registerAdditionalModels(final Docket docket, final TypeResolver typeResolver) {
        docket.additionalModels(
                typeResolver.resolve(PaymentsJson.class));
    }

    @Bean
    public UniqueIdSetterPlugin uniqueIdSetterPlugin(@Value("${spring.application.name}") final String applicationName) {
        return new UniqueIdSetterPlugin(applicationName);
    }

    @Bean
    public Docket paymentsApi(final SwaggerApi swaggerApi) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(excludePaths(swaggerApi))
                .build()
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))
                .useDefaultResponseMessages(false)
                .additionalModels(typeResolver.resolve(Errors.class), typeResolver.resolve(Pagination.class))
                .globalResponseMessage(RequestMethod.GET, getResponseMessages())
                .globalResponseMessage(RequestMethod.POST, getResponseMessages())
                .globalResponseMessage(RequestMethod.PUT, getResponseMessages())
                .globalResponseMessage(RequestMethod.DELETE, getResponseMessages())
                .globalResponseMessage(RequestMethod.PATCH, getResponseMessages())
                .globalResponseMessage(RequestMethod.HEAD, getResponseMessages())
                .apiInfo(new ApiInfo(
                        "",
                        "",
                        "1",
                        "",
                        new Contact(null, "http://software-in-harmony.blogspot.com", "roman.szarowski@gmail.com"),
                        null,
                        null,
                        new ArrayList<>()));
    }

    private List<ResponseMessage> getResponseMessages() {
        return newArrayList(
                new ResponseMessage(400, "Your request is malformed",
                        new ModelRef("Errors"), newTreeMap(), newArrayList()),
                new ResponseMessage(404, "The specified object could not be found",
                        new ModelRef("Errors"), newTreeMap(), newArrayList()),
                new ResponseMessage(422, "Your request is well-structured, but some parameter value isn't valid",
                        new ModelRef("Errors"), newTreeMap(), newArrayList()),
                new ResponseMessage(500, "We had a problem with our server, try again later",
                        new ModelRef("Errors"), newTreeMap(), newArrayList()),
                new ResponseMessage(503, "We're temporarily offline for maintenance, please try again later",
                        new ModelRef("Errors"), newTreeMap(), newArrayList()),
                new ResponseMessage(504, "We had a problem with our server and the request timed out, try again later",
                        new ModelRef("Errors"), newTreeMap(), newArrayList())
        );
    }

    private Predicate<String> excludePaths(final SwaggerApi swaggerApi) {
        return swaggerApi == null ? ant("/v1/**") : swaggerApi.isInternal() ? ant(swaggerApi.getBasePath() + "/**")
                : input -> input != null && input.startsWith(swaggerApi.getBasePath()) && swaggerApi.getExcludedPaths() != null
                && swaggerApi.getExcludedPaths().stream().noneMatch(p -> Pattern.compile(
                        "^" + swaggerApi.getBasePath().replaceAll(CHARS_TO_ESCAPE, Matcher.quoteReplacement("\\"))
                                + ".*" + p.replaceAll(CHARS_TO_ESCAPE, Matcher.quoteReplacement("\\")) + ".*$").matcher(input).matches());
    }
}