package main;

import service.WebServiceImpl;
import service.WebServiceImplService;

public class WeatherClient {
    public static void main(String[] args) {
        WebServiceImplService webServiceImplService = new WebServiceImplService();
        WebServiceImpl webService = webServiceImplService.getPort(WebServiceImpl.class);
        String weather = webService.queryWeather("杭州");
        System.out.println(weather);
    }
}
