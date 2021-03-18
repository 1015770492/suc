package top.yumbo.springcloud.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.User;
import top.yumbo.springcloud.user.dto.Mycollect;

import java.util.List;


@Component
@Mapper
public interface UserDao {
    User checkLogin(String userTel, String userPwd);

    boolean insertUser(User user);

    User selectUserByTel(String userTel);

    boolean updateUser(User user);
    boolean updateUserPwd(String userTel,String userPwd);
    List<Collect> selectCollectCount(Integer userId);
    List<Mycollect> selectCollect(long userId);
    boolean deletCollect(long collectId);

}
