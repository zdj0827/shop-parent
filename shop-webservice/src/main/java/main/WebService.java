package main;

import service.WebServiceImpl;

import javax.xml.ws.Endpoint;

public class WebService {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/weather",new WebServiceImpl());
    }
}
