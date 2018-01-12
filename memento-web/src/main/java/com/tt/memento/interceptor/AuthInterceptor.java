package com.tt.memento.interceptor;

import com.tt.memento.model.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录拦截器
 * date: 2018/1/9
 * author: wt
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserEntity operator = (UserEntity) request.getSession().getAttribute("user_session");
        if (operator == null) {
            String requestedWith = request.getHeader("x-requested-with");
            String loginUrl = "/login";
            // ajax请求
            if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
                String loginAlert = "<script>$.messager.alert('提示', '登录超时,请重新登录!',function(data){window.location.href='" + loginUrl + "'});</script>";
                response.setHeader("session-status", "timeout");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(loginAlert);
            } else {
                response.sendRedirect(loginUrl);
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        String contextPath = request.getContextPath();
        if (modelAndView != null) {
            request.setAttribute("base", contextPath);
        }
    }
}
