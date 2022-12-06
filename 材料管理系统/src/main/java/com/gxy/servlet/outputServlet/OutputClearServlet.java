package com.gxy.servlet.outputServlet;

import com.gxy.dao.impl.InputDaoImpl;
import com.gxy.dao.impl.OutputDaoImpl;
import com.gxy.domain.Output;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/outputclear")
public class OutputClearServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputDaoImpl outputDao = new OutputDaoImpl();
        PrintWriter writer = resp.getWriter();
        writer.write("<h3>清除成功！！！</h3>");
        outputDao.outputClear();
    }
}
