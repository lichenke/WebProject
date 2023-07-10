package com.example.webproject.web;

import com.example.webproject.common.StatusCode;
import com.example.webproject.service.LoginService;
import com.example.webproject.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.example.webproject.common.LoginStatusCode.LOGIN_SUCCESS;
import static top.ideacl.top.ValidateCode.isCodeRight;

// 这个servlet负责进行业务逻辑的处理
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private static final String err = "errorMsg";

    private static final String CURRENT_USER = "CURRENT_USERNAME";

    LoginService loginService = new LoginServiceImpl();

    // 两个请求模式走的流程一样
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        String vCode = req.getParameter("vcode");
        if (name == null || "".equals(name)) {
            req.setAttribute(err, "用户名为空");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        // 数据回填
        req.setAttribute("username", name);
        if (pwd == null || "".equals(pwd)) {
            req.setAttribute(err, "密码为空");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        if (vCode == null || "".equals(vCode)) {
            req.setAttribute(err, "验证码为空");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        // check code first
        if (isCodeRight(req, resp, vCode)) {
            StatusCode code = loginService.login(name, pwd);
            if (LOGIN_SUCCESS.equals(code)) {
                // login successfully
                HttpSession session = req.getSession();
                session.setAttribute(CURRENT_USER, name);
                req.getRequestDispatcher("user?type=list").forward(req, resp);
            } else {
                req.setAttribute(err, code.getMsg());
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute(err, "验证码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
