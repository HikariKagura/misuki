package fun.lain.mizuki.misuki.moudels;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping("/loginpage")
    public String toLogin(){
        return "login/login";
    }

}
