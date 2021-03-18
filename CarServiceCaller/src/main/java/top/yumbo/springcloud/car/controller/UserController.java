package top.yumbo.springcloud.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yumbo.springcloud.car.dto.Mycollect;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.User;
import top.yumbo.springcloud.car.feigninterface.UserServiceCaller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Resource
    private UserServiceCaller call;

    @RequestMapping("/checkLogin")
    public void checkLogin(String userTel, String userPwd, HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        User user = call.checkLogin(userTel, userPwd);
        if (user != null) {
            session.setAttribute("loginuser", user);
            out.print("<script>alert('登录成功！');location.href='../index.jsp';</script>");
        } else {
            out.print("<script>alert('登录失败！')；history.go(-1);</script>");
        }
        out.flush();
        out.close();
    }

    @RequestMapping("/insertUser")
    public void insertUser(String userTel, String userName, String userPwd, HttpSession session, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        user.setUserTel(userTel);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (call.insertUser(user)) {
            User user1 = call.checkLogin(userTel, userPwd);
            if (user1 != null) {
                session.setAttribute("loginuser", user1);
                out.print("<script>alert('注册成功！');location.href='../index.jsp';</script>");
            } else {
                out.print("<script>alert('注册失败！')；history.go(-1);</script>");
            }
        } else {
            out.print("<script>alert('注册失败！')；history.go(-1);</script>");
        }
        out.flush();
        out.close();
    }

    @RequestMapping("/selectUserByTel")
    @ResponseBody
    public String selectUserByTel(String userTel) {
        User user = call.selectUserByTel(userTel);
        if(user!=null){
            return "ok";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/updateUser")
    public void updateUser(String userTel, String userName, HttpSession session, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("loginuser");
        user.setUserName(userName);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (call.updateUser(user)) {
            session.setAttribute("loginuser", user);
            out.print("<script>alert('修改成功！');location.href='../yhcenter.jsp';</script>");
        } else {
            out.print("<script>alert('修改失败！')；history.go(-1);</script>");
        }
        out.flush();
        out.close();
    }

    @RequestMapping("/nologin")
    public void noLogin(HttpSession session, HttpServletResponse response) throws IOException {
        session.removeAttribute("loginuser");
        session.invalidate();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print("<script>alert('注销成功！');location.href='../index.jsp';</script>");
        out.flush();
        out.close();
    }

    @RequestMapping("/checkPwd")
    @ResponseBody
    public String checkPwd(String userTel, String userPwd) {

        User user = call.checkLogin(userTel, userPwd);
        if (user != null) {
            return "ok";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/updatePwd")
    public void updatePwd(String userTel, String userPwd, HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        if (call.updateUserPwd(userTel, userPwd)) {
//            System.out.println("---------------------2");
////            User user = call.checkLogin(userTel, userPwd);
            User user = (User) session.getAttribute("loginuser");
            user.setUserPwd(userPwd);
            session.setAttribute("loginuser", user);
            out.print("<script>alert('修改成功！');location.href='../yhcenter.jsp';</script>");

        } else {
            out.print("<script>alert('修改失败！');history.go(-1);</script>");
        }
        out.flush();
        out.close();
    }
    @RequestMapping("/selectCollectCount")
    @ResponseBody
    public List<Collect> selectCollectCount(Integer userId){

        List<Collect> list= call.selectCollectCount(userId);
        return list;
    }
    @RequestMapping("/selectCollect")
    @ResponseBody
    public List<Mycollect> selectCollect( long userId){
        return call.selectCollect(userId);
    }

    @RequestMapping("/deleteCollect")
    public void deleteCollect(long collectId, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if(call.deletCollect(collectId)) {
            out.print("<script>alert('取消成功！');location.href='../mycollect.jsp';</script>");
        }else{
            out.print("<script>alert('取消失败！');history.go(-1);</script>");
        }
        out.flush();
        out.close();
    }
}
