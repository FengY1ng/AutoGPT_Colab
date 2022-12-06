package com.gxy.servlet.warehouseServlet;

import com.gxy.dao.OutputDao;
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
import java.util.HashMap;
@WebServlet("/warehouseupdatebyid")
public class WarehouseUpdateByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WarehouseDao warehouseDao = new WarehouseDaoImpl();
        WareHouse wareHouse = new WareHouse();
        String id = req.getParameter("ID");
        wareHouse.setID(id);
        String name = req.getParameter("name");
        wareHouse.setName(name);
        int num = Integer.parseInt( req.getParameter("num"));
        wareHouse.setNum(num);
        int sell_price = Integer.parseInt( req.getParameter("sell_price"));
        wareHouse.setSell_price(sell_price);
        warehouseDao.warehouseUpdate(wareHouse);
        req.getRequestDispatcher("/warehouseselect").forward(req,resp);
    }
}
