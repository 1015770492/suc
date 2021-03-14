package top.yumbo.springcloud.car.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TableName(value = "t_car")
public class Car implements Serializable {

  @TableId
  private long carId;
  private String carType;
  private String carBrand;
  private String carColor;
  private double carPrice;
  private String carDescription;
  private String carInfo;
  private String carArea;
  private String carImage;
  private String carRegtime;
  private String carMileage;
  private String carStatus;


}
