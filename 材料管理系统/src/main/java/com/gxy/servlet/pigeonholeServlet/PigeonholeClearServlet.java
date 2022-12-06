package com.gxy.servlet.pigeonholeServlet;

import com.gxy.dao.PigeonholeDao;
import com.gxy.dao.impl.PigeonholeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pigeonholeclear")
public class PigeonholeClearServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PigeonholeDao pigeonholeDao = new PigeonholeDaoImpl();
        pigeonholeDao.PigeonholeClear();
        req.getRequestDispatcher("selectAllPigeonhole.jsp").forward(req,resp);
    }
}
