package com.zhanghl.first.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @description: 接口请求日志保存
 * @author: zhanghailang
 * @date: 2022/7/18 10:38
 */
//@WebFilter(urlPatterns = {"/contract/interviewer-c/*","/contract/interviewer-b/*"}, filterName = "SaveInterfaceLogFilter")
//@Component
//@Configuration
public class SaveInterfaceLogFilter extends OncePerRequestFilter {

//    @Autowired
//    private CommonGateway commonGateway;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        try {
            filterChain.doFilter(requestWrapper, responseWrapper);
        } catch (Exception e) {
            logger.info("解析异常 {}", e);
        } finally {
            try {
                if (requestWrapper.getMethod().equals("POST")) {
//                    this.commonGateway.saveGigInterfaceLog(new GigInterfaceLogDO() {{
//                        setInterfaceName(requestWrapper.getRequestURI());
//                        setReceiveData(StrUtil.str(requestWrapper.getContentAsByteArray(), Charset.defaultCharset()));
//                        setRemark(StrUtil.str(responseWrapper.getContentAsByteArray(), Charset.defaultCharset()));
//                    }});
                }
//                if (requestWrapper.getMethod().equals("GET")) {
//                    this.commonGateway.saveGigInterfaceLog(new GigInterfaceLogDO() {{
//                        setInterfaceName(requestWrapper.getRequestURI());
//                        setReceiveData(requestWrapper.getParameterMap().toString());
//                        setRemark(StrUtil.str(responseWrapper.getContentAsByteArray(), Charset.defaultCharset()));
//                    }});
//                }
            } catch (Exception e) {
                logger.info("保存接口日志异常 {}", e);
            } finally {
                responseWrapper.copyBodyToResponse();
            }
        }
    }

}