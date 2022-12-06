package com.gxy.dao.impl;

import com.gxy.common.JdbcConn;
import com.gxy.dao.InputDao;
import com.gxy.domain.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputDaoImpl implements InputDao {
    @Override
    public void inputInsert(String id, String name, int num, int trade_price, String date_in) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet = null;
        try {
            System.out.println("1");
            connection = JdbcConn.getConnection();
            String sql = "insert into input values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);   //id
            preparedStatement.setString(2, name);  //name
            preparedStatement.setInt(3, num);   //num
            preparedStatement.setInt(4, trade_price);   //trade_price
            preparedStatement.setString(5, date_in);   //date_in
            int i1 = preparedStatement.executeUpdate();
            if (i1 != -1) {
                System.out.println("入库成功！！！");
            }
            String sql1 = "select * from warehouse where id=?";   //判断总表中是否存在 id
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1, id);
            resultSet = preparedStatement1.executeQuery();
            if (resultSet.next()) {
                System.out.println("2");
                //表中存在id 增加num的数量
                sql = "update warehouse set num=num+?";
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
                preparedStatement2.setInt(1, num);
                int i = preparedStatement2.executeUpdate();
            } else {
                System.out.println("3");
                //总表中不存储id  插入数据
                sql = "insert into warehouse values(?,?,?,?)";
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
                preparedStatement2.setString(1, id);
                preparedStatement2.setString(2, name);
                preparedStatement2.setInt(3, num);
                preparedStatement2.setInt(4, trade_price*2);
                int i = preparedStatement2.executeUpdate();
                System.out.println(i);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement1 != null)
                    preparedStatement1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void inputUpdate(Input input) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int num=0;
        try {
            connection = JdbcConn.getConnection();

            String sql="update  input set name=?,num=?,trade_price=?,date_in=? where ID=?";
            String sql1="select num from input where ID=?";
            String sql2="update warehouse set name=?,num=num+?,sell_price=? where ID=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,input.getName());
            preparedStatement.setInt(2,input.getNum());
            preparedStatement.setInt(3,input.getTrade_price());
            preparedStatement.setString(4,input.getDate_in());
            preparedStatement.setString(5,input.getID());


            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1,input.getID());
            ResultSet resultSet = preparedStatement1.executeQuery();
            if(resultSet.next()){
                num = resultSet.getInt(1);
            }
            int i = preparedStatement.executeUpdate();
            if(i!=-1){
                System.out.println("更改成功！！！");
            }
            num=input.getNum()-num;  //总数变化！！！
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setString(1,input.getName());
            preparedStatement2.setInt(2,num);
            preparedStatement2.setInt(3,input.getTrade_price()*2);
            preparedStatement2.setString(4,input.getID());
            int i1 = preparedStatement2.executeUpdate();
            if(i1!=-1){
                System.out.println("总表更改成功！！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void inputCount() {

    }

    @Override
    public void inputDelete(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        int num = 0;
        try {
            connection = JdbcConn.getConnection();
            String sql = "delete  from input where id=?";
            String sql1 = "select num from input where id=?";
            String sql2 = "update warehouse set num=num-? where id=?";
            preparedStatement = connection.prepareStatement(sql); //删除
            preparedStatement1 = connection.prepareStatement(sql1); //查找数量
            preparedStatement2 = connection.prepareStatement(sql2);   //更新总表数量
            preparedStatement1.setString(1, id);
            ResultSet resultSet = preparedStatement1.executeQuery();
            if (resultSet.next()) {
                num = resultSet.getInt(1); //获取入库表数量
            }
            preparedStatement2.setInt(1, num);
            preparedStatement2.setString(2, id);
            int i1 = preparedStatement2.executeUpdate();
            preparedStatement.setString(1, id);
            int i = preparedStatement.executeUpdate();
            if (i != -1 && i1 != -1) {
                System.out.println("删除成功!!!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement1 != null) {
                try {
                    preparedStatement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement2 != null) {
                try {
                    preparedStatement2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Input inputQuery(String id) {
        Input input=new Input();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = JdbcConn.getConnection();
            String sql="select * from input where ID=?";
            preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String string = resultSet.getString(1);
                String string1 = resultSet.getString(2);
                int anInt = resultSet.getInt(3);
                int anInt1 = resultSet.getInt(4);
                String string2 = resultSet.getString(5);
                input.setID(string);
                input.setName(string1);
                input.setNum(anInt);
                input.setTrade_price(anInt1);
                input.setDate_in(string2);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }return input;
    }

    @Override
    public List<Input> inputSelect() {
        List<Input> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcConn.getConnection();
            Scanner in = new Scanner(System.in);
            String sql = "select * from input ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Input input = new Input();
                input.setID(resultSet.getString(1));
                input.setName(resultSet.getString(2));
                input.setNum(resultSet.getInt(3));
                input.setTrade_price(resultSet.getInt(4));
                input.setDate_in(resultSet.getString(5));
                list.add(input);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void inputClear() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = JdbcConn.getConnection();
            String sql="delete from input";
            preparedStatement = connection.prepareStatement(sql);
            int i = preparedStatement.executeUpdate();
            if(i!=-1){
                System.out.println("清除成功");
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
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
