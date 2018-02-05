package cxf.service;


import cxf.interfaces.WeatherInterface;

public class WeatherInterfaceImpl implements WeatherInterface {
    @Override
    public String queryWeather(String city) {
        String weather = null;
        if("杭州".equals(city)){
            weather = "雨雪交加";
        }else{
            weather = "晴";
        }
        return city+":"+weather;
    }
}
