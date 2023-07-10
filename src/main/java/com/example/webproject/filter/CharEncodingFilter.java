package com.example.webproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CharEncodingFilter implements Filter {

    // 执行过滤的动作
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 通过过滤器设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 放行：继续去执行下一个过滤器或者servlet请求
        chain.doFilter(req, resp);
    }

    // 过滤器被初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化CharEncodingFilter");
    }

    // 过滤器被销毁
    @Override
    public void destroy() {
        System.out.println("CharEncodingFilter过滤器被销毁");
    }
}
