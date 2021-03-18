package top.yumbo.springcloud.car.feigninterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.yumbo.springcloud.car.dto.Myreserve;
import top.yumbo.springcloud.car.entity.Reserve;

import java.util.List;

@FeignClient(value = "CAR-SERVICE-PROVIDER")
public interface ReserveServiceCaller {

    @RequestMapping("/reserveController/reserveCar")
    Boolean reserveCar(@RequestBody Reserve reserve);

    @RequestMapping("/reserveController/findMyReservation")
    List<Myreserve> findMyReservation(@RequestParam(value = "userId") long userId);

    @RequestMapping("/reserveController/delReservation")
    Boolean delReservation(@RequestParam(value = "reserveId") long reserveId);
}
