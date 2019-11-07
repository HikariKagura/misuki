package fun.lain.mizuki.misuki.config.exception;

import fun.lain.mizuki.misuki.config.utils.Echo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// RestControllerAdvice和ControllerAdvice的区别，与RestController和Controller的区别一样，
// Rest返回的是一个json串，而Controller返回的是一个视图（View），会交给模板引擎进行渲染
// 返回一个页面
public class RestExceptionAdapters {


    @ExceptionHandler(value = {AuthorizationException.class, UnauthorizedException.class})
    public Echo handleRestAuthException(){
        return Echo.error(Echo.Code.ERROR,"无权访问！");
    }

    @ExceptionHandler(value = RestException.class)
    public Echo handleRestException(RestException e){
        return Echo.error(e.getMessage());

    }
}
