package top.yumbo.springcloud.car.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yumbo.springcloud.car.dao.TCarDao;
import top.yumbo.springcloud.car.entity.Car;

import java.util.List;


@Service
public class CarService {
    @Autowired
    TCarDao tCarDao;

    public JSONObject getCarByPage(Integer currentPage, Integer pageSize){
        QueryWrapper<Car> queryWrapper=new QueryWrapper<Car>();
        System.out.println(pageSize);
        Page<Car> page=new Page<>(currentPage,pageSize);//当前页是1，每页2条记录
        //传入要进行的分页以及查询构造条件
        IPage<Car> tCarIPage = tCarDao.selectPage(page, queryWrapper);

        System.out.println("总页数"+tCarIPage.getPages());//打印总页数
        System.out.println("总记录数数"+tCarIPage.getTotal());//总记录数
        List<Car> carList=tCarIPage.getRecords();//获取当前页的内容，返回的是一个List集合
//        carList.forEach(System.out::println);//遍历打印
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",tCarIPage.getTotal());
        jsonObject.put("pageTotal",tCarIPage.getPages());
        jsonObject.put("pageSize",tCarIPage.getSize());
        System.out.println(jsonObject);
        jsonObject.put("list",carList);
        return jsonObject;
    }

    public boolean deleteCarById(Integer carId) {
        final int i = tCarDao.deleteById(carId);
        return i == 1 ? true : false;
    }

    public int updateByTCar(Car tCar) {
        try {
            return tCarDao.updateById(tCar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
