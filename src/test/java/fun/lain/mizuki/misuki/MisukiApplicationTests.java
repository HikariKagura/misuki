package fun.lain.mizuki.misuki;

import fun.lain.mizuki.misuki.moudels.user.dao.UserDao;
import fun.lain.mizuki.misuki.moudels.user.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MisukiApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    UserDao userDao;

    @Test
    public void testUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("764326696@qq.com");
        userInfo.setUserName("Mizuki");
        userInfo.setPassword("123456");
        userDao.insert(userInfo);
    }

    @Test
    public void testSelect(){
        System.out.println(userDao.selectOne(new QueryWrapper<UserInfo>().eq("email","764326696@qq.com")));
    }
}
