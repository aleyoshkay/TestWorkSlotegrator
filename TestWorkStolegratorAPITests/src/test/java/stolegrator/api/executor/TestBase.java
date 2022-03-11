package stolegrator.api.executor;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.FilterableRequestSpecification;


public interface TestBase {
    RequestSpecBuilder specBuilder = (new RequestSpecBuilder()).setContentType(ContentType.JSON).setRelaxedHTTPSValidation();
    FilterableRequestSpecification requestSpec = (FilterableRequestSpecification) specBuilder.build();
}

