package com.payments.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AbstractApiDocsGeneratingTest {

    private static final String API_URI = "/v2/api-docs";
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String SWAGGER_OUTPUT_PATH = USER_DIR + "/build/swagger";

    @Autowired
    private WebApplicationContext wac;

    protected void generateApiDocs() throws Exception {
        final ResultHandler rh = r -> {
            final Path swaggerDir = Paths.get(SWAGGER_OUTPUT_PATH);
            Files.createDirectories(swaggerDir);
            if (Files.isDirectory(swaggerDir)) {
                final Path swaggerFile = swaggerDir.resolve("internal.json");
                Files.deleteIfExists(swaggerFile);
                Files.createFile(swaggerFile);
                final String swaggerJSONAsString = r.getResponse().getContentAsString();
                Files.write(swaggerFile, swaggerJSONAsString.getBytes("UTF-8"));
            }
        };

        final MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        mockMvc.perform(get(API_URI).accept(MediaType.APPLICATION_JSON))
                .andDo(rh)
                .andExpect(status().isOk());
    }
}