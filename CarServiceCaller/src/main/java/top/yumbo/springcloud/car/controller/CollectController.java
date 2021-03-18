package top.yumbo.springcloud.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yumbo.springcloud.car.entity.Collect;
import top.yumbo.springcloud.car.entity.User;
import top.yumbo.springcloud.car.feigninterface.CollectServiceCaller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/collectController")
public class CollectController {

    @Resource
    private CollectServiceCaller collectServiceCaller;

    @RequestMapping("/addCollection")
    public void addCollection(long car_id, HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        User loginuser= (User) session.getAttribute("loginuser");
        if(loginuser!=null){
            long user_id=loginuser.getUserId();
            Collect c = collectServiceCaller.checkCollection(user_id, car_id);
            if (c != null) {
                out.print("<script>alert('您已经收藏过啦！');history.go(-1);</script>");
            } else {
                Collect collect = new Collect();
                collect.setUserId(user_id);
                collect.setCarId(car_id);
                Boolean b = collectServiceCaller.addCollection(collect);
                if (b) {
                    out.print("<script>alert('收藏成功！');history.go(-1);</script>");
                } else {
                    out.print("<script>alert('收藏失败！');history.go(-1);</script>");
                }
            }
        }else{
            out.print("<script>alert('请您先登录！');history.go(-1);</script>");
        }
        out.flush();
        out.close();
    }
}
