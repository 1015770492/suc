package top.yumbo.springcloud.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yumbo.springcloud.car.entity.Collect;
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
    public void addCollection(Integer car_id, HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        Integer user_id = 1;

        Collect c = collectServiceCaller.checkCollection(user_id, car_id);
        if (c != null) {
            out.print("<script>alert('您已经收藏过啦！');history.go(-1);</script>");
        } else {
            Collect collect = new Collect();
            collect.setUserId(user_id);
            collect.setCarId(car_id);
            Boolean b = collectServiceCaller.addCollection(collect);
            if (b) {
                out.print("<script>alert('收藏成功！');</script>");
            } else {

            }
        }
        out.flush();
        out.close();
    }
}
