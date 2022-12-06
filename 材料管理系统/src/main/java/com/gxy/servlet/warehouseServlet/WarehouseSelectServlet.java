package com.gxy.servlet.warehouseServlet;

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

@WebServlet("/warehouseselect")

public class WarehouseSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl();
        List<WareHouse> wareHouses = warehouseDao.warehouseSelect();
        req.setAttribute("warehouselist",wareHouses);
        req.getRequestDispatcher("selectAllWarehouse.jsp").forward(req,resp);
    }
}
