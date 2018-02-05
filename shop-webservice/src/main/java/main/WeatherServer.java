package main;

import interfaces.WeatherInterface;


import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import service.WeatherInterfaceImpl;

public class WeatherServer {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setServiceClass(WeatherInterface.class);
        factoryBean.setServiceBean(new WeatherInterfaceImpl());
        factoryBean.setAddress("http://127.0.0.1:8080/weather");
        factoryBean.create();
    }
}
