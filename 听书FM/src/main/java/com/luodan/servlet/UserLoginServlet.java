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
 * @date ：2021/2/7 0:20
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    UserService userService;
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            User user= userService.login(username,password);
            if(user == null) {
                resp.sendRedirect("/login.html");
                return;
            }
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/");


        } catch (SQLException throwables) {
            throw new ServletException(throwables);
        }

    }
}
