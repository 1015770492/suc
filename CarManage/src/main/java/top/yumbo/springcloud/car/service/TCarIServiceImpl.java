package top.yumbo.springcloud.car.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yumbo.springcloud.car.dao.TCarDao;
import top.yumbo.springcloud.car.entity.Car;

@Service
public class TCarIServiceImpl extends ServiceImpl<TCarDao, Car> implements TCarIService{
}
