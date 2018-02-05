package cxf.client;

import cxf.service.WeatherInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WeatherClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-cxf-webservice.xml");
        WeatherInterface weatherInterface = (WeatherInterface)context.getBean("weatherClient");
        String result = weatherInterface.queryWeather("杭州");
        System.out.println(result);
    }
}
