package com.gxy.dao.impl;

import com.gxy.common.JdbcConn;
import com.gxy.dao.PigeonholeDao;
import com.gxy.domain.Pigeonhole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PigeonholeDaoImpl implements PigeonholeDao {

    @Override
    public List<Pigeonhole> PigeonholeSelect() {
        List<Pigeonhole> list=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        PreparedStatement preparedStatement1=null;
        PreparedStatement preparedStatement2=null;
        ResultSet resultSet=null;
        ResultSet resultSet1=null;
        Connection connection=null;
        try {
             connection = JdbcConn.getConnection();
            String sql="select * from input";
            String sql1="insert into pigeonhole values (?,?,?,?,?)";
            String sql2="select * from output";
            String sql3="select * from pigeonhole";
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement1 = connection.prepareStatement(sql1);
             preparedStatement2 = connection.prepareStatement(sql2);
             resultSet = preparedStatement.executeQuery();
             resultSet1 = preparedStatement2.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                int num = resultSet.getInt(3);
                String state="入库";
                String date_in = resultSet.getString(5);
                preparedStatement1.setString(1,id);
                preparedStatement1.setString(2,name);
                preparedStatement1.setInt(3,num);
                preparedStatement1.setString(4,state);
                preparedStatement1.setString(5,date_in);
                int i = preparedStatement1.executeUpdate();
                if(i!=-1){
                    System.out.println("插入成功！！！");
                }
            }
            while (resultSet1.next()){
                String id = resultSet1.getString(1);
                String name = resultSet1.getString(2);
                int num = resultSet1.getInt(3);
                String state="出库";
                String date_in = resultSet1.getString(5);
                preparedStatement1.setString(1,id);
                preparedStatement1.setString(2,name);
                preparedStatement1.setInt(3,num);
                preparedStatement1.setString(4,state);
                preparedStatement1.setString(5,date_in);
                int i = preparedStatement1.executeUpdate();
                if(i!=-1){
                    System.out.println("插入成功！！！");
                }
            }
            PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
            ResultSet resultSet2 = preparedStatement3.executeQuery();
            while (resultSet2.next()){
                Pigeonhole pigeonhole=new Pigeonhole();
                pigeonhole.setID(resultSet2.getString(1));
                pigeonhole.setName(resultSet2.getString(2));
                pigeonhole.setNum(resultSet2.getInt(3));
                pigeonhole.setState(resultSet2.getString(4));
                pigeonhole.setDate(resultSet2.getString(5));
                list.add(pigeonhole);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement1!=null){
                try {
                    preparedStatement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement2!=null){
                try {
                    preparedStatement2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(resultSet1!=null){
                try {
                    resultSet1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    return list;
    }

    @Override
    public void PigeonholeClear() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
             connection = JdbcConn.getConnection();
            String sql="delete from pigeonhole";
             preparedStatement = connection.prepareStatement(sql);
            int i = preparedStatement.executeUpdate();
            if(i!=-1){
                System.out.println("清除成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Pigeonhole> PigeonholeSelectGood() {
        List<Pigeonhole> list=new ArrayList<>();
        String sql="select * from pigeonhole";
        PreparedStatement preparedStatement=null;
        Connection connection=null;
        try {
             connection = JdbcConn.getConnection();
             preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet2 = preparedStatement.executeQuery();
            while (resultSet2.next()){
                Pigeonhole pigeonhole=new Pigeonhole();
                pigeonhole.setID(resultSet2.getString(1));
                pigeonhole.setName(resultSet2.getString(2));
                pigeonhole.setNum(resultSet2.getInt(3));
                pigeonhole.setState(resultSet2.getString(4));
                pigeonhole.setDate(resultSet2.getString(5));
                list.add(pigeonhole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

}
