package top.yumbo.springcloud.car.biz;


import top.yumbo.springcloud.car.dto.Myreserve;
import top.yumbo.springcloud.car.entity.Car;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.Reserve;

import java.util.List;

public interface CarBiz {

    List<Car> getIndexCars();

    List<Car> getAllCars();

    Car findCarById(long carId);

    List<Car> getSearchCars(String keys);

    Boolean reserveCar(Reserve reserve);

    Boolean addCollection(Collect collect);

    Collect checkCollection(long userId, long carId);

    List<Car> findUserCollections(long userId);

    Boolean delCollection(long userId, long carId);

    public List<Myreserve> findMyReservation(long userId);

    public Boolean delReservation(long reserveId);
}
