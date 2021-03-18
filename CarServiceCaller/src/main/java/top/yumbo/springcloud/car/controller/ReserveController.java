package top.yumbo.springcloud.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yumbo.springcloud.car.dto.Mycollect;
import top.yumbo.springcloud.car.dto.Myreserve;
import top.yumbo.springcloud.car.entity.Reserve;
import top.yumbo.springcloud.car.entity.User;
import top.yumbo.springcloud.car.feigninterface.ReserveServiceCaller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/reserveController")
public class ReserveController {

    @Resource
    private ReserveServiceCaller reserveServiceCaller;

    @RequestMapping("/addReservation")
    public void addReservation(Integer car_id, String time, String place, String phone, HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        User loginuser= (User) session.getAttribute("loginuser");
        if (loginuser!=null){
            long user_id=loginuser.getUserId();
            Reserve reserve=new Reserve();
            reserve.setUserId(user_id);
            reserve.setCarId(car_id);
            reserve.setReserveTime(time);
            reserve.setReservePlace(place);
            reserve.setReserveTel(phone);
            Boolean b=reserveServiceCaller.reserveCar(reserve);
            if (b){
                out.print("<script>alert('预约成功！');location.href='../myreserve.jsp';</script>");
            }else{

            }
            out.flush();
            out.close();
        }else {
            out.print("<script>alert('请您先登录！');history.go(-1);</script>");
        }
    }

    @RequestMapping("/findMyReservation")
    @ResponseBody
    public List<Myreserve> findMyReservation(long userId){
        return reserveServiceCaller.findMyReservation(userId);
    }

    @RequestMapping("/delReservation")
    @ResponseBody
    public void deleteCollect(long reserveId, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if(reserveServiceCaller.delReservation(reserveId)) {
            out.print("<script>alert('取消成功！');location.href='../myreserve.jsp';</script>");
        }else{
            out.print("<script>alert('取消失败！');history.go(-1);</script>");
        }
        out.flush();
        out.close();
    }
}
