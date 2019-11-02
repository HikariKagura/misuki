package fun.lain.mizuki.misuki.moudels.user.controller;

import fun.lain.mizuki.misuki.moudels.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @RequestMapping("/login")
    public String login(String email,String password){
        return "" + userService.login(email, password);
    }

    @Resource
    UserService userService;
}
