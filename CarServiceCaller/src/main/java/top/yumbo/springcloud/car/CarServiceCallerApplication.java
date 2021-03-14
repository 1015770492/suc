package top.yumbo.springcloud.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class CarServiceCallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceCallerApplication.class);
    }
}
