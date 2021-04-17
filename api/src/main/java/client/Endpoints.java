package client;

public final class Endpoints {
    public static final String BASE_URL = ApiClient.config.getProperty("baseUrl");
    public static final String COMPUTE_URL = ApiClient.config.getProperty("computeUrl");
    public static final String OPERATION_URL = ApiClient.config.getProperty("operationUrl");
}
