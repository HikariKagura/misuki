package fun.lain.mizuki.misuki.moudels.user.controller;

import fun.lain.mizuki.misuki.moudels.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/login")
    public String login(String email,String password){
        return "" + userService.login(email, password);
    }


}
