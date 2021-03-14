package top.yumbo.springcloud.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yumbo.springcloud.car.biz.CarBiz;
import top.yumbo.springcloud.car.entity.Reserve;

import javax.annotation.Resource;

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
}
