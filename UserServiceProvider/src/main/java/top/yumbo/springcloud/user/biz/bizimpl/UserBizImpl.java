package top.yumbo.springcloud.user.biz.bizimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.User;
import top.yumbo.springcloud.user.biz.UserBiz;
import top.yumbo.springcloud.user.dao.UserDao;
import top.yumbo.springcloud.user.dto.Mycollect;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBizImpl implements UserBiz {
    @Autowired
    private UserDao userDao;
    @Override
    public User checkLogin(String userTel, String userPwd) {
        return userDao.checkLogin(userTel, userPwd);
    }

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User selectUserByTel(String userTel) {
        return userDao.selectUserByTel(userTel);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean updateUserPwd(String userTel, String userPwd) {
        return userDao.updateUserPwd(userTel, userPwd);
    }

    @Override
    public List<Collect> selectCollectCount(Integer userId) {
        return userDao.selectCollectCount(userId);
    }

    @Override
    public List<Mycollect> selectCollect(long userId) {
        return userDao.selectCollect(userId);
    }

    @Override
    public boolean deletCollect(long collectId) {
        return userDao.deletCollect(collectId);
    }
}
