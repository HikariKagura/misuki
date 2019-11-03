package fun.lain.mizuki.misuki.moudels.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

}
