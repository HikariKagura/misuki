package fun.lain.mizuki.misuki.moudels.user.controller;

import fun.lain.mizuki.misuki.moudels.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.security.Security;

@Controller
@RequestMapping("/api")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/login")
    public String login(String email,  String password, boolean remember){
        UsernamePasswordToken token = new UsernamePasswordToken(email,password);
        token.setRememberMe(remember);
        SecurityUtils.getSubject().login(token);
        return "redirect:/index";
    }



}
