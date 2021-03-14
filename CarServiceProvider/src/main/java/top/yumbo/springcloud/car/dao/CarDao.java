package top.yumbo.springcloud.car.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.yumbo.springcloud.car.entity.Car;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.Reserve;

import java.util.List;

@Mapper
@Component
public interface CarDao {

    public List<Car> getIndexCars();//查询index显示的二手车信息

    public List<Car> getAllCars();//查询所有二手车信息

    public Car findCarById(Integer carId);

    public List<Car> getSearchCars(String keys);

    public Boolean reserveCar(Reserve reserve);

    public Boolean addCollection(Collect collect);

    public Collect checkCollection(Integer userId,Integer carId);

    public List<Car> findUserCollections(Integer userId);

    public Boolean delCollection(Integer userId,Integer carId);
}
