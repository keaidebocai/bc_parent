package top.woaibocai.eduservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"top.woaibocai"})
public class ServiceEduMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEduMain8001.class,args);
    }
}