package top.woaibocai.voidservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"top.woaibocai"})
public class ServiceVoid8003 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVoid8003.class,args);
    }
}