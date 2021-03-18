package top.yumbo.springcloud.user.biz;

import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.User;
import top.yumbo.springcloud.user.dto.Mycollect;

import java.util.List;

public interface UserBiz {
    public User checkLogin(String userTel, String userPwd);
    public boolean insertUser(User user);
    public User selectUserByTel(String userTel);
    public boolean updateUser(User user);
    boolean updateUserPwd(String userTel,String userPwd);
    List<Collect> selectCollectCount(Integer userId);
    List<Mycollect> selectCollect(long userId);
    boolean deletCollect(long collectId);
}
