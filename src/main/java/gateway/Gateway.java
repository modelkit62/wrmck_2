package gateway;

import model.DownStreamApiResponse;
import util.MyRestTemplate;

public class Gateway {

    private final MyRestTemplate restTemplate = new MyRestTemplate();
    private final String baseUrl;

    public Gateway(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public DownStreamApiResponse executeGateway(String s) {


        return restTemplate.postForObject(baseUrl + "/index", s,  DownStreamApiResponse.class);
    }
}
