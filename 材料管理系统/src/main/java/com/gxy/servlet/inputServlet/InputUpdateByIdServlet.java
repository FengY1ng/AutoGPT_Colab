package com.gxy.servlet.inputServlet;

import com.gxy.dao.InputDao;
import com.gxy.dao.impl.InputDaoImpl;
import com.gxy.domain.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/inputupdatebyid")
public class InputUpdateByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputDaoImpl inputDao = new InputDaoImpl();
        Input input = new Input();
        String id = req.getParameter("ID");
        input.setID(id);
        String name = req.getParameter("name");
        input.setName(name);
        int num = Integer.parseInt( req.getParameter("num"));
        input.setNum(num);
        int trade_price = Integer.parseInt( req.getParameter("trade_price"));
        input.setTrade_price(trade_price);
        String date_in = req.getParameter("date_in");
        input.setDate_in(date_in);
        inputDao.inputUpdate(input);
        req.getRequestDispatcher("/inputselect").forward(req,resp);
    }
}
