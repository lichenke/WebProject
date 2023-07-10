package com.example.webproject.web;


import com.example.webproject.common.StatusCode;
import com.example.webproject.service.UserService;
import com.example.webproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.webproject.common.RegisterStatusCode.REGISTER_SUCCESS;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final String err = "errorMsg";

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        String confirm = req.getParameter("confirm");
        if (name == null || "".equals(name)) {
            req.setAttribute(err, "用户名为空");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        if (pwd == null || "".equals(pwd)) {
            req.setAttribute(err, "密码为空");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        if (confirm == null || "".equals(confirm)) {
            req.setAttribute(err, "确认密码为空");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        if (!pwd.equals(confirm)) {
            req.setAttribute(err, "两次密码不一致");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        StatusCode code = userService.register(name, pwd);
        if (REGISTER_SUCCESS.equals(code)) {
            req.setAttribute("msg", code.getMsg());
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            req.setAttribute(err, code.getMsg());
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
