package com.gxy.servlet.inputServlet;

import com.gxy.dao.impl.InputDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 入库表插入
 */
@WebServlet("/inputinsert")
public class InputInsertServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("ID");
        String name = req.getParameter("name");
        int num = Integer.parseInt(req.getParameter("num"));
        int trade_price = Integer.parseInt(req.getParameter("trade_price"));
        String date_in = req.getParameter("date_in");
        InputDaoImpl inputDao = new InputDaoImpl();
        inputDao.inputInsert(id,name,num,trade_price,date_in);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/inputselect");
        requestDispatcher.forward(req,resp);
    }
}
