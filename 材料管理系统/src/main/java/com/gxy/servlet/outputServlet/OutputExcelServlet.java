package com.gxy.servlet.outputServlet;

import com.gxy.common.ExceIUtils;
import com.gxy.dao.impl.InputDaoImpl;
import com.gxy.dao.impl.OutputDaoImpl;
import com.gxy.domain.Input;
import com.gxy.domain.Output;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.struts.taglib.html.HtmlTag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/outputexcel")
public class OutputExcelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputDaoImpl outputDao = new OutputDaoImpl();
        List<Output> list1 = outputDao.outputSelect();
        try {
            ExceIUtils.export2Web(resp, "出库信息", "出库信息", Output.class, list1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
