package com.gxy.servlet.warehouseServlet;

import com.gxy.common.ExceIUtils;
import com.gxy.dao.WarehouseDao;
import com.gxy.dao.impl.OutputDaoImpl;
import com.gxy.dao.impl.WarehouseDaoImpl;
import com.gxy.domain.Output;
import com.gxy.domain.WareHouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/warehouseexcel")
public class WarehouseExcelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WarehouseDao warehouseDao = new WarehouseDaoImpl();
        List<WareHouse> list1 = warehouseDao.warehouseSelect();
        try {
            ExceIUtils.export2Web(resp, "仓库信息", "仓库信息", WareHouse.class, list1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
