package top.yumbo.springcloud.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.User;
import top.yumbo.springcloud.user.biz.UserBiz;
import top.yumbo.springcloud.user.dto.Mycollect;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Resource
    private UserBiz userBiz;
    @RequestMapping("/checkLogin")
    @ResponseBody
    public User checkLogin(@RequestParam String userTel,@RequestParam String userPwd){
        return userBiz.checkLogin(userTel, userPwd);
    }
    @RequestMapping("/insertUser")
    @ResponseBody
   public boolean insertUser(@RequestBody User user){
        return userBiz.insertUser(user);
   }
    @RequestMapping("/selectUserByTel")
    @ResponseBody
   public User selectUserByTel(@RequestParam String userTel){
        return userBiz.selectUserByTel(userTel);
   }
    @RequestMapping("/updateUser")
    @ResponseBody
   public boolean updateUser(@RequestBody User user){
        return userBiz.updateUser(user);
   }
    @RequestMapping("/updateUserPwd")
    @ResponseBody
    boolean updateUserPwd(@RequestParam String userTel,@RequestParam String userPwd){
        return userBiz.updateUserPwd(userTel, userPwd);
    }
    @RequestMapping("/selectCollectCount")
    @ResponseBody
    public List<Collect> selectCollectCount(@RequestParam Integer userId){
        return userBiz.selectCollectCount(userId);
    }
    @RequestMapping("/selectCollect")
    @ResponseBody
    public List<Mycollect> selectCollect(@RequestParam long userId){
        return userBiz.selectCollect(userId);
    }
    @RequestMapping("/deletCollect")
    @ResponseBody
    boolean deletCollect(@RequestParam long collectId){
        return userBiz.deletCollect(collectId);
    }
}
