package cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.14
 * 2018-01-31T19:29:51.495+08:00
 * Generated source version: 3.1.14
 * 
 */
@WebService(targetNamespace = "http://interfaces.cxf/", name = "WeatherInterface")
@XmlSeeAlso({ObjectFactory.class})
public interface WeatherInterface {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "queryWeather", targetNamespace = "http://interfaces.cxf/", className = "cxf.service.QueryWeather")
    @WebMethod
    @ResponseWrapper(localName = "queryWeatherResponse", targetNamespace = "http://interfaces.cxf/", className = "cxf.service.QueryWeatherResponse")
    public String queryWeather(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0
    );
}
