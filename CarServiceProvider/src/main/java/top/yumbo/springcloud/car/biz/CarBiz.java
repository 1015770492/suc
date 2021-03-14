package top.yumbo.springcloud.car.biz;


import top.yumbo.springcloud.car.entity.Car;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.Reserve;

import java.util.List;

public interface CarBiz {

    List<Car> getIndexCars();

    List<Car> getAllCars();

    Car findCarById(Integer carId);

    List<Car> getSearchCars(String keys);

    Boolean reserveCar(Reserve reserve);

    Boolean addCollection(Collect collect);

    Collect checkCollection(Integer userId, Integer carId);

    List<Car> findUserCollections(Integer userId);

    Boolean delCollection(Integer userId, Integer carId);
}
