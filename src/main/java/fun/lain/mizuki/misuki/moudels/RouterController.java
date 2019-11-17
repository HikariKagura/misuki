package fun.lain.mizuki.misuki.moudels;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping("/login")
    public String toLogin(){
        //返回模路径，由于模板引擎默认配置了模板路径，以及模板后缀，
        //因此实际上模板引擎去找的就是 classpath:/templates/user/login.html
        return "user/login";
    }
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/403")
    public String to403(){
        return "error/403";
    }

    @RequestMapping("/background")
    public String toBackground() {
        return "background/background";
    }
    @RequestMapping("/publish")
    public String toPublish(){
        return "publish";
    }
    @RequestMapping("/mylib")
    public String toMylib(){
        return "mylibrary";
    }
}

