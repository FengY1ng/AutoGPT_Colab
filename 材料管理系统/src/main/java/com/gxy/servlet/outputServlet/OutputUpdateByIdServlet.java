package com.gxy.servlet.outputServlet;

import com.gxy.dao.OutputDao;
import com.gxy.dao.impl.InputDaoImpl;
import com.gxy.dao.impl.OutputDaoImpl;
import com.gxy.domain.Input;
import com.gxy.domain.Output;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/outputupdatebyid")
public class OutputUpdateByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputDao outputDao = new OutputDaoImpl();
        Output output = new Output();
        String id = req.getParameter("ID");
        output.setID(id);
        String name = req.getParameter("name");
        output.setName(name);
        int num = Integer.parseInt( req.getParameter("num"));
        output.setNum(num);
        int sell_price = Integer.parseInt( req.getParameter("sell_price"));
        output.setSell_price(sell_price);
        String date_out = req.getParameter("date_out");
        output.setDate_out(date_out);
        outputDao.outputUpdate(output);
        req.getRequestDispatcher("/outputselect").forward(req,resp);
    }
}
