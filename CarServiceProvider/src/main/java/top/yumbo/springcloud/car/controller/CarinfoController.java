package top.yumbo.springcloud.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yumbo.springcloud.car.biz.CarBiz;
import top.yumbo.springcloud.car.entity.Car;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/carinfoController")
public class CarinfoController {

    @Resource
    private CarBiz carBiz;

    @RequestMapping("/getIndexCars")
    @ResponseBody
    public List<Car> getIndexCars(){
        return carBiz.getIndexCars();
    }

    @RequestMapping("/getAllCars")
    @ResponseBody
    public List<Car> getAllCars(){
        return carBiz.getAllCars();
    }

    @RequestMapping("/getCarDetail")
    @ResponseBody
    public Car findCarById(@RequestParam Integer car_id){
        return carBiz.findCarById(car_id);
    }

    @RequestMapping("/getSearchCars")
    @ResponseBody
    public List<Car> getSearchCars(@RequestParam String keys){
        return carBiz.getSearchCars("%"+keys+"%");
    }
}
