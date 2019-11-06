package fun.lain.mizuki.misuki.moudels.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user_info")
public class UserInfo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private  String password;
    private String email;
    private Integer state;
    private String role;//用户权限
}
