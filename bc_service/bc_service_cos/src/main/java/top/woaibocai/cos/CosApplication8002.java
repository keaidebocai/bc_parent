package top.woaibocai.cos;

import com.alibaba.druid.pool.DataSourceNotAvailableException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



/**
 * @program: bc_parent
 * @description: 腾讯云COS对象存储
 * @author: woaibocai
 * @create: 2023-10-03 18:26
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"top.woaibocai"})
public class CosApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(CosApplication8002.class,args);
    }
}
