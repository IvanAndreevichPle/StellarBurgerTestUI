package web_api_clients;

import config.BaseConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

public class Client {

    BaseConfig config = ConfigFactory.create(BaseConfig.class);
    private final String MAIN_URL = config.mainURL();

    protected RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(MAIN_URL)
                .build();
    }
}
