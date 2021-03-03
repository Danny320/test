package com.luodan.servlet;

import com.luodan.model.User;
import com.luodan.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/2/6 23:02
 */
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
    private UserService userService;
    public void init() throws ServletException{
        userService = new UserService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User user = userService.register(username,password);
            if(user == null) {
                //没有注册成功
                resp.sendRedirect("/register.html");
                return;
            }

            //把当前用户种入 session 中，下次资源访问时携带的登录用户信息
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            //注册成功跳回首页
            resp.sendRedirect("/");

        } catch (SQLException e) {
            throw new ServletException(e);

        }

    }
}
