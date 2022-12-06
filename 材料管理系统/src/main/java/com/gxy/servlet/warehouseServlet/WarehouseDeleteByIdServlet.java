package com.gxy.servlet.warehouseServlet;

import com.gxy.dao.OutputDao;
import com.gxy.dao.WarehouseDao;
import com.gxy.dao.impl.OutputDaoImpl;
import com.gxy.dao.impl.WarehouseDaoImpl;
import com.gxy.domain.WareHouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/warehousedeletebyid")
public class WarehouseDeleteByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WarehouseDao wareHouse = new WarehouseDaoImpl();
        String id = req.getParameter("ID");
        wareHouse.warehouseDelete(id);
        req.getRequestDispatcher("/warehouseselect").forward(req,resp);
    }
}
