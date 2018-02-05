package main;

import cxf.service.WeatherInterface;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class WeatherClient_CXF {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(WeatherInterface.class);
        factoryBean.setAddress("http://127.0.0.1:8080/weather");
        WeatherInterface weatherInterface = factoryBean.create(WeatherInterface.class);
        String weather = weatherInterface.queryWeather("北京");
        System.out.println(weather);
    }
}
