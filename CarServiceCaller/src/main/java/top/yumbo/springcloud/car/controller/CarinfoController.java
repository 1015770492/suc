package top.yumbo.springcloud.car.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yumbo.springcloud.car.entity.Car;
import top.yumbo.springcloud.car.feigninterface.CarinfoServiceCaller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/carinfoController")
public class CarinfoController {

    @Resource
    private CarinfoServiceCaller carinfoServiceCaller;

    @RequestMapping("/getIndexCars")
    @ResponseBody
    public void getIndexCars(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        List<Car> indexCars=carinfoServiceCaller.getIndexCars();
        Gson gson=new Gson();
        String json=gson.toJson(indexCars);
        out.print(json);
        out.flush();
        out.close();
    }

    @RequestMapping("/getAllCars")
    @ResponseBody
    public void getAllCars(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        List<Car> indexCars=carinfoServiceCaller.getAllCars();
        Gson gson=new Gson();
        String json=gson.toJson(indexCars);
        out.print(json);
        out.flush();
        out.close();
    }

    @RequestMapping("/getCarDetail")
    @ResponseBody
    public void getCarDetail(long car_id, HttpSession session,HttpServletResponse response) throws IOException {
        Car car=carinfoServiceCaller.findCarById(car_id);
        session.setAttribute("car",car);
        response.sendRedirect("/cardetail.jsp");
    }

    @RequestMapping("/setKeys")
    @ResponseBody
    public void setKeysInSession(String keys,HttpSession session,HttpServletResponse response) throws IOException {
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!:"+keys);keys
        if (keys!=null && keys!=""){
            session.setAttribute("keys",keys);
            response.sendRedirect("/carlist.jsp");
        }else {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter out=response.getWriter();
            out.print("<script>alert('请输入关键字！');history.go(-1);</script>");
            out.flush();
            out.close();
        }
    }

    @RequestMapping("/getSearchCars")
    @ResponseBody
    public void getSearchCars(HttpSession session,HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String keys= (String) session.getAttribute("keys");
        List<Car> cars=carinfoServiceCaller.getSearchCars(keys);
        Gson gson=new Gson();
        String json=gson.toJson(cars);
        out.print(json);
        out.flush();
        out.close();
    }


}


