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
@TableName(value = "t_reserve")
public class Reserve implements Serializable {

  @TableId
  private long reserveId;
  private String reserveTime;
  private String reservePlace;
  private long userId;
  private long carId;
  private String reserveTel;

}
