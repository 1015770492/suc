package top.yumbo.springcloud.car.spider;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import top.yumbo.springcloud.car.entity.Car;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class MySpider {
    public static void main(String[] args) {
        final String html = new RestTemplate().getForObject("https://www.58.com/ershouche/", String.class);
        final List<String> hrefList = Jsoup.parse(html).body().getElementsByClass("icon_main").get(0).getElementsByTag("a").stream().map(a -> {
            return "https:"+a.attr("href");
        }).collect(Collectors.toList());
        hrefList.parallelStream().forEach(href->{
            catchPage(href);
        });

    }

    private static void catchPage(String url) {
        final String forObject = new RestTemplate().getForObject(url, String.class);
        final Elements uls = Jsoup.parse(forObject).body().getElementsByClass("creatCarList");
        final List<Car> tCarList = uls.stream().flatMap(ul -> {
            final Elements lis = ul.getElementsByTag("li");
            return lis.stream().map(li -> {
                final Car tCar = new Car();
//                System.out.println(li);
                final String href = li.getElementsByTag("img").get(0).attr("data-original");
                final String carInfo = li.getElementsByClass("carInfo").get(0).text();
//                System.out.println(carInfo);
                final String address = li.getElementsByClass("thisAddress").get(0).text();
                final String regTime = li.getElementsByClass("time1").get(0).text();
                final String mileage = li.getElementsByClass("time1").get(0).nextElementSibling().text();
                final String priceText = li.getElementsByTag("i").get(0).parent().text();
                final BigDecimal bigDecimal = new BigDecimal(priceText.substring(1, priceText.length() - 1));
                final int price = bigDecimal.multiply(new BigDecimal(10000)).intValue();
                final String mileStr = mileage.split(" ")[1];
                tCar.setCarImage(href);
                tCar.setCarDescription(carInfo);// 简略信息
                tCar.setCarArea(address);
                tCar.setCarRegtime(regTime.split(" ")[1]);
                tCar.setCarMileage(mileStr.replaceAll("万公里", ""));
                tCar.setCarPrice(price);
                tCar.setCarStatus("待售");
                tCar.setCarType("轿车");
                tCar.setCarBrand(carInfo.split(" ")[0]);
                return tCar;
            });
        }).collect(Collectors.toList());

        final HttpEntity<String> reqestEntity = new HttpEntity<>(JSONObject.toJSONString(tCarList), null);
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        restTemplate.postForObject("http://localhost:8080/car/batch", reqestEntity, String.class);
    }
}
