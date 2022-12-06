package com.gxy.servlet.warehouseServlet;

import com.gxy.dao.WarehouseDao;
import com.gxy.dao.impl.WarehouseDaoImpl;
import com.gxy.domain.WareHouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/warehouseupdate")
public class WarehouseUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("ID");
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl();
        List<WareHouse> wareHouses = warehouseDao.warehouseQuery(id);
        req.setAttribute("warehouselist",wareHouses);
        req.getRequestDispatcher("updateWarehouse.jsp").forward(req,resp);

    }
}
