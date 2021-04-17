package client;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ApiClient {

    protected static Properties config = new Properties();
    private static final Logger LOGGER = LogManager.getLogger("client.ApiClient");
    private final RequestSpecification requestSpecification = getInitialSpecification();

    static {
        LOGGER.info("Loading config file:");
        try (InputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
            config.load(inputStream);
        } catch (FileNotFoundException e) {
            LOGGER.error("Properties file not found");
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        RestAssured.baseURI =
                System.getProperty("baseUrl") != null ? System.getProperty("baseUrl") : Endpoints.BASE_URL;
        RestAssured.port =
                Integer.parseInt(System.getProperty("port") != null ? System.getProperty("port") : config.getProperty("port"));
        RestAssured.basePath =
                System.getProperty("basePath") != null ? System.getProperty("basePath") : config.getProperty("basePath");
    }

    private RequestSpecification getInitialSpecification() {
        List<Filter> filters = Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
        return new RequestSpecBuilder()
                    .addFilters(filters)
                    .build()
                    .accept("application/json");
    }

    public ValidatableResponse post(String url, Object jsonObject) {
        return RestAssured
                .given()
                    .spec(requestSpecification)
                    .contentType(ContentType.JSON)
                    .body(jsonObject)
                .when()
                    .post(url)
                .then();
    }

    public ValidatableResponse get(String url, Map<String, Integer> queryParam) {
        return RestAssured
                .given()
                    .spec(requestSpecification)
                    .params(queryParam)
                .when()
                    .get(url)
                .then();
    }

    public ValidatableResponse get(String url, String operationName, Map<String, Integer> queryParam) {
        return RestAssured
                .given()
                    .spec(requestSpecification)
                    .pathParam("operation", operationName)
                    .params(queryParam)
                .when()
                    .get(url)
                .then();
    }
}
