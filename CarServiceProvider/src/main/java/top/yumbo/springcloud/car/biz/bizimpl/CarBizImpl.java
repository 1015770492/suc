package top.yumbo.springcloud.car.biz.bizimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yumbo.springcloud.car.biz.CarBiz;
import top.yumbo.springcloud.car.dao.CarDao;
import top.yumbo.springcloud.car.entity.Car;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.Reserve;
import java.util.List;

@Service
public class CarBizImpl implements CarBiz {

    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> getIndexCars() {
        return carDao.getIndexCars();
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Override
    public Car findCarById(Integer carId) {
        return carDao.findCarById(carId);
    }

    @Override
    public List<Car> getSearchCars(String keys) {
        return carDao.getSearchCars("%"+keys+"%");
    }

    @Override
    public Boolean reserveCar(Reserve reserve) {
        return carDao.reserveCar(reserve);
    }

    @Override
    public Boolean addCollection(Collect collect) {
        return carDao.addCollection(collect);
    }

    @Override
    public Collect checkCollection(Integer userId, Integer carId) {
        return carDao.checkCollection(userId, carId);
    }

    @Override
    public List<Car> findUserCollections(Integer userId) {
        return carDao.findUserCollections(userId);
    }

    @Override
    public Boolean delCollection(Integer userId, Integer carId) {
        return carDao.delCollection(userId,carId);
    }
}
