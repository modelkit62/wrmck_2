package service;

import gateway.Gateway;
import model.DownStreamApiResponse;

public class Service {

    private final Gateway gateway;


    public Service() {
        gateway = null;
    }

    public DownStreamApiResponse executeService(String s) {

        return gateway.executeGateway(s);
    }
}
