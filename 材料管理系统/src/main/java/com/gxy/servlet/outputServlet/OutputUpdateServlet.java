package com.gxy.servlet.outputServlet;

import com.gxy.dao.InputDao;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/outputupdate")
public class OutputUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputDao OutputDao=new OutputDaoImpl();
        String id = req.getParameter("ID");
        List<Output> OutputList=new ArrayList<>();
        Output Output = OutputDao.outputQuery(id);
        OutputList.add(Output);
        req.setAttribute("outputlist",OutputList);
        req.getRequestDispatcher("updateoutput.jsp").forward(req,resp);
    }
}
