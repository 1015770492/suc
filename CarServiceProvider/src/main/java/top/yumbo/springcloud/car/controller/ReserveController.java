package top.yumbo.springcloud.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yumbo.springcloud.car.biz.CarBiz;
import top.yumbo.springcloud.car.dto.Myreserve;
import top.yumbo.springcloud.car.entity.Reserve;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/reserveController")
public class ReserveController {

    @Resource
    private CarBiz carBiz;

    @RequestMapping("/reserveCar")
    @ResponseBody
    public Boolean reserveCar(@RequestBody Reserve reserve){
        return carBiz.reserveCar(reserve);
    }

    @RequestMapping("/findMyReservation")
    @ResponseBody
    public List<Myreserve> findMyReservation(@RequestParam long userId){
        return carBiz.findMyReservation(userId);
    }

    @RequestMapping("/delReservation")
    @ResponseBody
    public Boolean delReservation(@RequestParam long reserveId){
        return carBiz.delReservation(reserveId);
    }

}
