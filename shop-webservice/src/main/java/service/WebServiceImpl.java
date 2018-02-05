package service;

import interfaces.WebServiceInterface;

import javax.jws.WebService;

@WebService
public class WebServiceImpl implements WebServiceInterface {
    @Override
    public String queryWeather(String city) {
        return city+":晴";
    }
}
