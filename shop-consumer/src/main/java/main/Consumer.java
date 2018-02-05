package main;

import interfaces.DubboProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dubbo-consumer.xml");
        context.start();
        DubboProviderService service = (DubboProviderService) context.getBean("providerServiceImpl");
        System.out.println(service.sayHello("zdj"));
    }
}
