package com.gxy.servlet;

import com.gxy.dao.impl.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        LoginDao loginDao = new LoginDao();
        int login = loginDao.login(username, password);
        if(login==1){
            req.getRequestDispatcher("head.jsp").forward(req,resp);
        }
        else {
            PrintWriter writer = resp.getWriter();
            writer.write("<h3>您不是管理人员！！！</h3>");
        }
    }
}
