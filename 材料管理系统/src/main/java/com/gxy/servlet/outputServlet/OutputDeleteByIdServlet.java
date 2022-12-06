package com.gxy.servlet.outputServlet;

import com.gxy.dao.InputDao;
import com.gxy.dao.OutputDao;
import com.gxy.dao.impl.InputDaoImpl;
import com.gxy.dao.impl.OutputDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/outputdeletebyid")
public class OutputDeleteByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputDao outputDao = new OutputDaoImpl();
        String id = req.getParameter("ID");
        outputDao.outputDelete(id);
        req.getRequestDispatcher("/outputselect").forward(req,resp);
    }
}
