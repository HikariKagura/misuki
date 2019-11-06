package fun.lain.mizuki.misuki.moudels.user.controller;

import fun.lain.mizuki.misuki.config.utils.Echo;
import fun.lain.mizuki.misuki.moudels.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Security;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping("/reg")
    //权限校验注解，要求访问此接口的必须要拥有以下角色，OR代表只要拥有其中任意一个就行，AND代表两者都要有
    @RequiresRoles(value = {"normal","superAdmin"},logical = Logical.OR)
    public Echo reg(){
        //Echo类作为Restful风格接口的通用信息返回类
        return Echo.success();
    }



}
