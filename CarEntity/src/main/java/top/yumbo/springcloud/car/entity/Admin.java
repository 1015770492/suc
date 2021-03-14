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
@TableName(value = "t_admin")
public class Admin implements Serializable {

  @TableId
  private long adminId;
  private String adminName;
  private String adminPwd;

}
