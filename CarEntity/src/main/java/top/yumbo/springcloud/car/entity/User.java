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
@TableName(value = "t_user")
public class User implements Serializable{

  @TableId
  private long userId;
  private String userName;
  private String userPwd;
  private String userArea;
  private long userTel;

}
