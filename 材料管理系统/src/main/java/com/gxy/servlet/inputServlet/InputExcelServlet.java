package com.gxy.servlet.inputServlet;

import com.gxy.common.ExceIUtils;
import com.gxy.dao.impl.InputDaoImpl;
import com.gxy.domain.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/inputexcel")
public class InputExcelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputDaoImpl inputDao = new InputDaoImpl();
        List<Input> list1 = inputDao.inputSelect();
        try {
            ExceIUtils.export2Web(resp, "入库信息", "入库信息", Input.class, list1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
