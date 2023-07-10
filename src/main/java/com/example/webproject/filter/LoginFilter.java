package com.example.webproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter({"/user"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("初始化LoginFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Object name = session.getAttribute("CURRENT_USERNAME");
        if (name == null) {
            req.setAttribute("msg", "未登录，请先登录");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter过滤器被销毁");
    }
}
