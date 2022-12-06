package com.gxy.dao;

import com.gxy.domain.Input;
import com.gxy.domain.WareHouse;

import java.util.List;

public interface WarehouseDao {
    //更新
    void warehouseUpdate(WareHouse wareHouse);

    //查询
    List<WareHouse> warehouseQuery(String id);

    //浏览
    List<WareHouse> warehouseSelect();

    //删除
    void warehouseDelete(String id);

}
