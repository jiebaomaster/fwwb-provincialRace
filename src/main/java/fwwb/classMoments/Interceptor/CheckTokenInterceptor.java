package fwwb.classMoments.Interceptor;

import fwwb.classMoments.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hongcj on 2017/4/28.
 */

public class CheckTokenInterceptor implements HandlerInterceptor {
    //定义不拦截的路由
    private static final String[] IGNORE_URI = {
            "/user/login.html",
            "/app","user/passwd_reset",
            "/webapp/user/admin",
            "/webapp/user/login"
    };

    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean passFlag = false;

        //排除不拦截的url请求
        String servletPath = httpServletRequest.getServletPath();
        for (String url : IGNORE_URI) {
            if (servletPath.contains(url)) {
                passFlag = true;
                break;
            }
        }
        if (passFlag) {
            return true;
        }

        //执行token验证
        try {
            String tokenStr = httpServletRequest.getHeader("access-token");
            String uid = httpServletRequest.getHeader("uid");
            passFlag = checkToken(tokenStr, uid);
        } catch (Exception e) {
            httpServletResponse.addHeader("errorMsg", e.getMessage());
            return false;
        }
        httpServletResponse.addHeader("token-access-status",Boolean.toString(passFlag));
        return passFlag;
    }

    private boolean checkToken(String tokenStr, String uid) {
        return userService.doCheckToken(tokenStr, uid);
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
