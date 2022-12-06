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
import java.util.HashMap;
@WebServlet("/inputdeletebyid")
public class InputDeleteByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputDao inputDao = new InputDaoImpl();
        String id = req.getParameter("ID");
        inputDao.inputDelete(id);
        req.getRequestDispatcher("/inputselect").forward(req,resp);
    }
}
