package com.gxy.servlet.pigeonholeServlet;

import com.gxy.common.ExceIUtils;
import com.gxy.dao.PigeonholeDao;
import com.gxy.dao.impl.OutputDaoImpl;
import com.gxy.dao.impl.PigeonholeDaoImpl;
import com.gxy.domain.Output;
import com.gxy.domain.Pigeonhole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pigeonholeexcel")
public class PigeonholeExcelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PigeonholeDao pigeonholeDao = new PigeonholeDaoImpl();
        List<Pigeonhole> list1 = pigeonholeDao.PigeonholeSelectGood();
        try {
            ExceIUtils.export2Web(resp, "出库信息", "出库信息", Pigeonhole.class, list1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
