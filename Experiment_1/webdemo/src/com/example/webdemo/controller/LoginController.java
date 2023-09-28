package com.example.webdemo.controller;

import com.example.webdemo.dao.UserDao;
import com.example.webdemo.dao.UserDaoImpl;
import com.example.webdemo.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserDao userDao=new UserDaoImpl( );
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String msg="登录成功，欢迎"+username+"!";
        try {
            Optional<User> daoResult=userDao.getUser(username, password);
            if ( daoResult.isEmpty()) {
                msg = "登录失败，用户名或密码错误!";
            }
        } catch (Exception e) {
            msg="登录失败，数据库访问错误! ";
        }
        req.setAttribute( "msg" ,msg);
        req.getRequestDispatcher("/WEB-INF/jsp/result.jsp" ).forward(req,resp);
    }
}
