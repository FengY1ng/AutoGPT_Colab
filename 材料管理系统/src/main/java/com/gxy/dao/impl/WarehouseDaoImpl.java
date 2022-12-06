package com.gxy.dao.impl;

import com.gxy.common.JdbcConn;
import com.gxy.dao.WarehouseDao;
import com.gxy.domain.WareHouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDaoImpl implements WarehouseDao {


    @Override
    public void warehouseUpdate(WareHouse wareHouse) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
             connection = JdbcConn.getConnection();
            String sql="update warehouse set name=?,num=?,sell_price=? where ID=?";
             preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,wareHouse.getName());
            preparedStatement.setInt(2,wareHouse.getNum());
            preparedStatement.setInt(3,wareHouse.getSell_price());
            preparedStatement.setString(4,wareHouse.getID());
            int i = preparedStatement.executeUpdate();
            if(i!=-1){
                System.out.println("更新成功");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<WareHouse> warehouseQuery(String id) {
        List<WareHouse> list=new ArrayList<>();
        WareHouse wareHouse=new WareHouse();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
             connection = JdbcConn.getConnection();
            String sql="select * from warehouse where ID=? ";
             preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("查询成功！");
                wareHouse.setID(resultSet.getString(1));
                wareHouse.setName(resultSet.getString(2));
                wareHouse.setNum(resultSet.getInt(3));
                wareHouse.setSell_price(resultSet.getInt(4));
            }
            list.add(wareHouse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public List<WareHouse> warehouseSelect() {
        List<WareHouse> list=new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = JdbcConn.getConnection();
            String sql="select * from warehouse  ";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                WareHouse wareHouse=new WareHouse();
                System.out.println("查询成功！");
                wareHouse.setID(resultSet.getString(1));
                wareHouse.setName(resultSet.getString(2));
                wareHouse.setNum(resultSet.getInt(3));
                wareHouse.setSell_price(resultSet.getInt(4));
                list.add(wareHouse);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public void warehouseDelete(String id) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = JdbcConn.getConnection();
            String sql="delete from warehouse where ID=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            int i = preparedStatement.executeUpdate();
            if(i!=-1){
                System.out.println("删除成功");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
