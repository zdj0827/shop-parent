package service;

import interfaces.DubboProviderService;

public class DubboProviderServiceImpl implements DubboProviderService{
    @Override
    public String sayHello(String name) {
        return "Hello!"+name;
    }
}
