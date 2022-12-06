package com.gxy.servlet.outputServlet;

import com.gxy.dao.OutputDao;
import com.gxy.dao.impl.InputDaoImpl;
import com.gxy.dao.impl.OutputDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 出库表插入
 */
@WebServlet("/outputinsert")
public class OutputInsertServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("ID");
        String name = req.getParameter("name");
        int num = Integer.parseInt(req.getParameter("num"));
        int sell_price = Integer.parseInt(req.getParameter("sell_price"));
        String date_out = req.getParameter("date_out");
        OutputDao outputDao = new OutputDaoImpl();
        outputDao.outputInsert(id,name,num,sell_price,date_out);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/outputselect");
        requestDispatcher.forward(req,resp);
    }
}
