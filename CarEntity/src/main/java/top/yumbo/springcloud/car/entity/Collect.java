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
@TableName(value = "t_collect")
public class Collect implements Serializable {

  @TableId
  private long collectId;
  private long userId;
  private long carId;


}
