package top.yumbo.springcloud.car.feigninterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.yumbo.springcloud.car.entity.Car;

import java.util.List;

@FeignClient(value = "CAR-SERVICE-PROVIDER")//value=“需要调用的服务在注册中心的服务名”
public interface CarinfoServiceCaller {

    //接口中方法结构和名字与对应的服务提供者控制器方法的结构和名字一致

    @RequestMapping("/carinfoController/getIndexCars")
    List<Car> getIndexCars();

    @RequestMapping("/carinfoController/getAllCars")
    List<Car> getAllCars();

    @RequestMapping("/carinfoController/getCarDetail")
    Car findCarById(@RequestParam(value = "car_id") long car_id);//对象参数用@RequestBody

    @RequestMapping("/carinfoController/getSearchCars")
    List<Car> getSearchCars(@RequestParam(value = "keys") String keys);

}
