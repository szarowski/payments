package com.payments.swagger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "swagger.enabled=true")
public class DocumentationInternalITest extends AbstractApiDocsGeneratingTest {

    @Test
    public void createSwaggerSpecInternal() throws Exception {
        generateApiDocs();
    }
}