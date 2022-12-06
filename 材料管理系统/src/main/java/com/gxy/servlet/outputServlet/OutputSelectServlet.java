package com.gxy.servlet.outputServlet;

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
import java.util.List;

@WebServlet("/outputselect")
public class OutputSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        OutputDaoImpl outputDao = new OutputDaoImpl();
        List<Output> outputlist = outputDao.outputSelect();
        System.out.println(outputlist);
        req.setAttribute("outputlist",outputlist);
        req.getRequestDispatcher("selectAllOutput.jsp").forward(req,resp);
    }
}
