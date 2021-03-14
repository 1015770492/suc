package top.yumbo.springcloud.car.feigninterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yumbo.springcloud.car.entity.Reserve;

@FeignClient(value = "eureka-client-car-service-provider")
public interface ReserveServiceCaller {

    @RequestMapping("/reserveController/reserveCar")
    Boolean reserveCar(@RequestBody Reserve reserve);
}
