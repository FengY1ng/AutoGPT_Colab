package com.gxy.servlet.pigeonholeServlet;

import com.gxy.dao.PigeonholeDao;
import com.gxy.dao.impl.PigeonholeDaoImpl;
import com.gxy.domain.Pigeonhole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pigeonholeselect")
public class PigeonholeSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PigeonholeDao pigeonholeDao=new PigeonholeDaoImpl();
        List<Pigeonhole> list = pigeonholeDao.PigeonholeSelect();
        req.setAttribute("pigeonholelist",list);
        req.getRequestDispatcher("selectAllPigeonhole.jsp").forward(req,resp);

    }
}
