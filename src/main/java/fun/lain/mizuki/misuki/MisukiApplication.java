package fun.lain.mizuki.misuki;

import fun.lain.mizuki.misuki.moudels.user.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "fun.lain.mizuki.misuki.moudels.**.dao")
public class MisukiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MisukiApplication.class, args);
    }
}
