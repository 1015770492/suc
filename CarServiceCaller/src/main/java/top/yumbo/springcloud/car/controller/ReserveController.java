package top.yumbo.springcloud.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yumbo.springcloud.car.entity.Reserve;
import top.yumbo.springcloud.car.feigninterface.ReserveServiceCaller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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

        Integer user_id=1;

        Reserve reserve=new Reserve();
        reserve.setUserId(user_id);
        reserve.setCarId(car_id);
        reserve.setReserveTime(time);
        reserve.setReservePlace(place);
        reserve.setReserveTel(phone);
        Boolean b=reserveServiceCaller.reserveCar(reserve);
        if (b){
            out.print("<script>alert('预约成功！');location.href='';</script>");
        }else{

        }
        out.flush();
        out.close();
    }
}
