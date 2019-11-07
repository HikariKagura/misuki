package fun.lain.mizuki.misuki.moudels.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.lain.mizuki.misuki.config.exception.RestException;
import fun.lain.mizuki.misuki.moudels.user.dao.UserDao;
import fun.lain.mizuki.misuki.moudels.user.entity.UserInfo;
import fun.lain.mizuki.misuki.moudels.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public boolean login(String email, String password) {
        UserInfo info = userDao.selectOne(new QueryWrapper<UserInfo>()
                .eq("email",email));
        if(info == null){
            return false;
        }
        if(info.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public boolean reg(UserInfo info) {
        if (info.getUserName()==null||info.getUserName().isEmpty()){
            throw new RestException("用户名不得为空！");
        }
        if (info.getPassword()==null||info.getPassword().isEmpty()){
            throw new RestException("密码不得为空！");
        }
        if (info.getEmail()==null||info.getEmail().isEmpty()){
            throw new RestException("邮箱不得为空！");
        }
        info.setRole("normal");
        return userDao.insert(info)==1?true:false;

    }
}
