package top.yumbo.springcloud.car.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.yumbo.springcloud.car.entity.Car;
import top.yumbo.springcloud.car.service.CarService;
import top.yumbo.springcloud.car.service.TCarIServiceImpl;

import java.util.List;


@CrossOrigin
@Controller
public class CarController {
    @Autowired
    CarService carService;
    @Autowired
    TCarIServiceImpl tCarIService;

    @GetMapping("/")
    public String index(){
        return "redirect:car/manage";
    }

    /**
     * @return 后台管理页面
     */
    @GetMapping("/car/manage")
    public String managePage() {
        return "/manage.html";
    }

    /**
     * 查询记车辆录
     *
     * @param currentPage 当前页
     * @param pageSize    每页多少条
     * @return 分页后的数据
     */
    @GetMapping("/car/all")
    @ResponseBody
    public JSONObject getAllCar(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                @RequestParam(value = "pageSize", defaultValue = "50") Integer pageSize) {
        return carService.getCarByPage(currentPage, pageSize);
    }


    /**
     * 删除汽车记录
     *
     * @param carId 车辆的主键id
     * @return 删除掉的汽车id，失败则返回-1；
     */
    @PostMapping("/car/delete")
    @ResponseBody
    public Boolean deleteCar(@RequestBody String carId) {
        System.out.println(carId);
        return carService.deleteCarById(JSONObject.parseObject(carId).getInteger("carId"));
    }

    /**
     * 更新车辆记录
     *
     * @param obj
     * @return
     */
    @PostMapping("/car/update")
    @ResponseBody
    public Boolean updateOne(@RequestBody String obj) {
        try {
            Car tCar = JSONObject.parseObject(obj, Car.class);
            return carService.updateByTCar(tCar) == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @PostMapping("/car/batch/insert")
    @ResponseBody
    public Boolean insertBatch(@RequestBody String json) {
        System.out.println(json);
        final List<Car> tCarList = JSONObject.parseArray(json, Car.class);
        return tCarIService.saveBatch(tCarList);
    }

    @PostMapping("/car/batch/delete")
    @ResponseBody
    public Boolean deleteBatch(@RequestBody String json){
        System.out.println(json);
        final JSONArray ids = JSONObject.parseObject(json).getJSONArray("ids");
        return tCarIService.removeByIds(ids.toJavaList(Integer.class));
    }

    @PostMapping("/car/batch/update")
    @ResponseBody
    public Boolean updateBatch(@RequestBody String json){
        System.out.println(json);
        final List<Car> tCarList = JSONObject.parseArray(json, Car.class);
        return tCarIService.saveOrUpdateBatch(tCarList);
    }

}
