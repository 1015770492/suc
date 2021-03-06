package top.yumbo.springcloud.car.feigninterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.yumbo.springcloud.car.entity.Car;
import top.yumbo.springcloud.car.entity.Collect;

import java.util.List;

@FeignClient(value = "CAR-SERVICE-PROVIDER")
public interface CollectServiceCaller {

    @RequestMapping("/collectController/addCollection")
    Boolean addCollection(@RequestBody Collect collect);

    @RequestMapping("/collectController/checkCollection")
    Collect checkCollection(@RequestParam(value = "user_id") long user_id,@RequestParam(value = "car_id") long car_id);

    @RequestMapping("/collectController/findUserCollections")
    List<Car> finUserCollections(@RequestParam(value = "user_id") long user_id);

    @RequestMapping("/collectController/delCollection")
    Boolean delCollection(@RequestParam(value = "user_id") long user_id,@RequestParam(value = "car_id") long car_id);
}
