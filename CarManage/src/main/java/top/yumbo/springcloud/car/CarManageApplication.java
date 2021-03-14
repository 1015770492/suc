package top.yumbo.springcloud.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("top.yumbo.springcloud.car.dao")
public class CarManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarManageApplication.class,args);
    }
}
