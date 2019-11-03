package fun.lain.mizuki.misuki.moudels.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.lain.mizuki.misuki.moudels.role.dao.UserPermDao;
import fun.lain.mizuki.misuki.moudels.role.dao.UserRoleDao;
import fun.lain.mizuki.misuki.moudels.role.dao.UserRoleRefDao;
import fun.lain.mizuki.misuki.moudels.role.entity.UserRole;
import fun.lain.mizuki.misuki.moudels.role.entity.UserRoleRef;
import fun.lain.mizuki.misuki.moudels.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    UserPermDao userPermDao;

    @Resource
    UserRoleDao userRoleDao;

    @Resource
    UserRoleRefDao userRoleRefDao;

    @Override
    public List<String> getUserRole(Long id) {
        //查询关联表，获取用户的全部角色ID
        List<UserRoleRef> roleRefs = userRoleRefDao.selectList(new QueryWrapper<UserRoleRef>()
                .eq("userId",id)
        );
        List<String> roles = new ArrayList<>();
        for(UserRoleRef ref: roleRefs){
            //通过关联信息，获取角色对象
            UserRole role = userRoleDao.selectById(ref.getRoleId());
            if(role!=null){
                roles.add(role.getRoleName());
            }
        }
        return roles;
    }
}
