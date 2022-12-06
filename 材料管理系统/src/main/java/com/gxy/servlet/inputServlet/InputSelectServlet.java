package com.gxy.servlet.inputServlet;

import com.gxy.dao.impl.InputDaoImpl;
import com.gxy.domain.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/inputselect")
public class InputSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        InputDaoImpl inputDao = new InputDaoImpl();
        List<Input> inputlist = inputDao.inputSelect();
        req.setAttribute("inputlist",inputlist);
        req.getRequestDispatcher("selectAllInput.jsp").forward(req,resp);
    }
}
