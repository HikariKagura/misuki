package fun.lain.mizuki.misuki.moudels.role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("auth_role")
public class UserRole {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String roleName;
    private String perms;
}
