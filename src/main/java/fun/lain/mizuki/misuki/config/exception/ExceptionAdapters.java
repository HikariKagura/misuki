package fun.lain.mizuki.misuki.config.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class ExceptionAdapters {

    @ExceptionHandler(value = {IncorrectCredentialsException.class, UnknownAccountException.class})
    public ModelAndView loginException(){
        ModelAndView view =new ModelAndView();
        view.setViewName("/error/403");
        view.addObject("message","登录失败！");
        return view;
    }

}
