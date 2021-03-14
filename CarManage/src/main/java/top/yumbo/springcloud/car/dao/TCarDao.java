package top.yumbo.springcloud.car.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.yumbo.springcloud.car.entity.Car;

@Mapper
@Component
public interface TCarDao extends BaseMapper<Car> {

}
