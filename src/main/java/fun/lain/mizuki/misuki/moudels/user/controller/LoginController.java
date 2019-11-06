package fun.lain.mizuki.misuki.moudels.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String login(String email, String password, boolean remember, ServletRequest request){

        UsernamePasswordToken token = new UsernamePasswordToken(email,password);
        token.setRememberMe(remember);
        SecurityUtils.getSubject().login(token);
        //获取上一次访问的地址
        SavedRequest reqUrl = WebUtils.getSavedRequest(request);
        if(reqUrl != null){
            String uri= reqUrl.getRequestURI();
            return "redirect:"+uri;
        }
        return "redirect:/index";
    }

    //登出接口
    @RequestMapping("/logout")
    public String logOut(){
        SecurityUtils.getSubject().logout();
        return "redirect:/index";
    }
}
