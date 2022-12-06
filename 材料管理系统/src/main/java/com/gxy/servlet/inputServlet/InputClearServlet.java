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
import java.io.PrintWriter;

@WebServlet("/inputclear")
public class InputClearServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputDaoImpl inputDao = new InputDaoImpl();
        PrintWriter writer = resp.getWriter();
        writer.write("<h3>清除成功！！！<h3>");
        inputDao.inputClear();
    }
}
