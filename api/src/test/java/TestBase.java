import client.ApiClient;
import client.Endpoints;
import io.restassured.response.ValidatableResponse;
import model.Operations;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;
    public class TestBase {

        private static ApiClient apiClient;

        @BeforeAll
        static void init() {
            apiClient = new ApiClient();
        }

        public ValidatableResponse getCalculation(Operations operation, Integer value1, Integer value2) {
            Map<String, Integer> queryParam = new HashMap<>();
            queryParam.put("val1", value1);
            queryParam.put("val2", value2);
            return apiClient.get(Endpoints.OPERATION_URL, operation.getName(), queryParam);
        }

        public ValidatableResponse postCalculation(Operations operation, Integer value1, Integer value2) {
            Map<String, String> queryMap = new HashMap<>();
            queryMap.put("val1", value1.toString());
            queryMap.put("val2", value2.toString());
            queryMap.put("operation", operation.getCode());
            return apiClient.post(Endpoints.COMPUTE_URL, queryMap);
        }
}
