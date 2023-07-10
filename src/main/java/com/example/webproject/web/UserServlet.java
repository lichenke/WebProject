package com.example.webproject.web;

import com.example.webproject.pojo.User;
import com.example.webproject.service.UserService;
import com.example.webproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type) {
            case "list":
                List<User> users = userService.listAll();
                req.setAttribute("users", users);
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                break;
            case "delete":
                String uid = req.getParameter("uid");
                resp.getWriter().print(userService.delete(Integer.parseInt(uid)));
                break;
            case "update":
                String id = req.getParameter("uid");
                User user = userService.getById(Integer.parseInt(id));
                req.setAttribute("user", user);
                req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
                break;
            case "update_":
                String uid1 = req.getParameter("uid");
                String password = req.getParameter("password");
                if (userService.update(uid1, password)) {
                    req.setAttribute("msg", "修改成功");
                    req.getRequestDispatcher("user?type=list").forward(req, resp);
                } else {
                    req.setAttribute("msg", "修改失败");
                    req.getRequestDispatcher("user?type=list").forward(req, resp);
                }
                break;
            default:
                throw new IllegalArgumentException("不支持的参数：" + type);
        }
    }
}
