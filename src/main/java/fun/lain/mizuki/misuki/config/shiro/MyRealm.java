package fun.lain.mizuki.misuki.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.lain.mizuki.misuki.moudels.role.service.RoleService;
import fun.lain.mizuki.misuki.moudels.role.service.impl.RoleServiceImpl;
import fun.lain.mizuki.misuki.moudels.user.dao.UserDao;
import fun.lain.mizuki.misuki.moudels.user.entity.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Resource
    UserDao userDao;

    @Resource
    RoleService roleService = new RoleServiceImpl();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserInfo info = (UserInfo)principalCollection.getPrimaryPrincipal();
        List<String> roles = roleService.getUserRole(info.getId());
        SimpleAuthorizationInfo info1 = new SimpleAuthorizationInfo();
        Set roleSet = new HashSet<String>(roles);
        info1.setRoles(roleSet);
        return info1;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1 = (UsernamePasswordToken)token;
        String email = token1.getUsername();
        String password = String.copyValueOf(token1.getPassword());
        UserInfo info = userDao.selectOne(new QueryWrapper<UserInfo>().eq("email",email));
        if (info==null){
            throw new AuthenticationException("用户名或密码错误！");
        }
        if (info.getPassword().equals(password)){
            return new SimpleAuthenticationInfo(info,password,getName());
        }else{
            throw new AuthenticationException("用户名或密码错误！");
        }

    }

}
