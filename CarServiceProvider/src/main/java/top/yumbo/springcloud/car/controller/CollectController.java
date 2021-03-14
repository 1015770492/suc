package top.yumbo.springcloud.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yumbo.springcloud.car.biz.CarBiz;
import top.yumbo.springcloud.car.entity.Car;
import top.yumbo.springcloud.car.entity.Collect;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/collectController")
public class CollectController {

    @Resource
    private CarBiz carBiz;

    @RequestMapping("/addCollection")
    @ResponseBody
    public Boolean addCollection(@RequestBody Collect collect){
        return carBiz.addCollection(collect);
    }

    @RequestMapping("/checkCollection")
    @ResponseBody
    public Collect checkCollection(@RequestParam Integer user_id,@RequestParam Integer car_id){
        return carBiz.checkCollection(user_id, car_id);
    }

    @RequestMapping("/findUserCollections")
    @ResponseBody
    public List<Car> findUserCollections(@RequestParam Integer user_id){
        return carBiz.findUserCollections(user_id);
    }

    @RequestMapping("/delCollection")
    @ResponseBody
    public Boolean delCollection(@RequestParam Integer user_id,@RequestParam Integer car_id){
        return carBiz.delCollection(user_id, car_id);
    }

}
