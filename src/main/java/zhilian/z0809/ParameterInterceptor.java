package zhilian.z0809;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/9 0009 21:48
 */
public class ParameterInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String device = request.getParameter("device");
        BaseSignaureRequest signaureRequest = new BaseSignaureRequest();
        signaureRequest.setDevice(device);
        ThreadLocalCache.baseSignaureRequestThreadLocal.set(signaureRequest);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalCache.baseSignaureRequestThreadLocal.remove();
    }
}