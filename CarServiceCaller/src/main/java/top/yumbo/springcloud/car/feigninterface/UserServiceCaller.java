package top.yumbo.springcloud.car.feigninterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.yumbo.springcloud.car.dto.Mycollect;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.User;

import java.util.List;

@FeignClient(value = "USER-SERVICE-PROVIDER")
public interface UserServiceCaller {

    @RequestMapping("userController/checkLogin")
    public User checkLogin(@RequestParam(value = "userTel") String userTel, @RequestParam(value = "userPwd") String userPwd);

    @RequestMapping("userController/insertUser")
    public boolean insertUser(@RequestBody User user);

    @RequestMapping("userController/selectUserByTel")
    public User selectUserByTel(@RequestParam(value = "userTel") String userTel);

    @RequestMapping("userController/updateUser")
    public boolean updateUser(@RequestBody User user);
    @RequestMapping("userController/updateUserPwd")
    boolean updateUserPwd(@RequestParam(value = "userTel") String userTel,@RequestParam(value = "userPwd") String userPwd);

    @RequestMapping("userController/selectCollectCount")
    List<Collect> selectCollectCount(@RequestParam(value = "userId")    Integer userId);

    @RequestMapping("userController/selectCollect")
    List<Mycollect> selectCollect(@RequestParam(value = "userId") long userId);

    @RequestMapping("userController/deletCollect")
    boolean deletCollect(@RequestParam(value = "collectId")  long collectId);
}
