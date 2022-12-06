package com.gxy.dao.impl;

import com.gxy.common.JdbcConn;
import com.gxy.dao.OutputDao;
import com.gxy.domain.Input;
import com.gxy.domain.Output;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OutputDaoImpl implements OutputDao {
    @Override
    public void outputInsert(String id, String name, int num, int sell_price, String date_out) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet=null;
        int total=0;
        try {
            connection = JdbcConn.getConnection();
            String sql = "insert into output values(?,?,?,?,?)";   //出库表插入数据
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);   //id
            preparedStatement.setString(2, name);  //name
            preparedStatement.setInt(3, num);   //num
            preparedStatement.setInt(4, sell_price);   //sell_price
            preparedStatement.setString(5, date_out);   //date_out
            sql = "update warehouse set num=num-?";  //更总库中num的数量
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
            preparedStatement2.setInt(1, num);
            int i1 = preparedStatement2.executeUpdate(); //总表材料更新数量
            int i = preparedStatement.executeUpdate();  //入库表插入数据
            if (i != -1 && i1 != -1) {  //回滚数据！！！
                System.out.println("插入成功！！！");
            } else {
                System.out.println("插入失败！！！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(preparedStatement!=null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(preparedStatement1!=null)
                    preparedStatement1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(resultSet!=null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void outputUpdate(Output output) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int num=0;
        try {
            connection = JdbcConn.getConnection();
            String sql="update  output set name=?,num=?,sell_price=?,date_out=? where ID=?";
            String sql1="select num from output where ID=?";
            String sql2="update warehouse set name=?,num=num+?,sell_price=? where ID=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,output.getName());
            preparedStatement.setInt(2,output.getNum());
            preparedStatement.setInt(3,output.getSell_price());
            preparedStatement.setString(4,output.getDate_out());
            preparedStatement.setString(5,output.getID());

            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1,output.getID());
            ResultSet resultSet = preparedStatement1.executeQuery();
            if(resultSet.next()){
                num = resultSet.getInt(1);
            }
            int i = preparedStatement.executeUpdate();
            if(i!=-1){
                System.out.println("更改成功！！！");
            }
            num=output.getNum()-num;  //总数变化！！！
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setString(1,output.getName());
            preparedStatement2.setInt(2,num);
            preparedStatement2.setInt(3,output.getSell_price());
            preparedStatement2.setString(4,output.getID());
            int i1 = preparedStatement2.executeUpdate();
            if(i1!=-1){
                System.out.println("总表更改成功！！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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
    public void outputCount() {

    }

    @Override
    public void outputDelete(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        int num = 0;
        try {
            connection = JdbcConn.getConnection();
            String sql = "delete  from output where id=?";
            String sql1 = "select num from output where id=?";
            String sql2 = "update warehouse set num=num+? where id=?";
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
    public Output outputQuery(String id) {
        return null;
    }

    @Override
    public List<Output> outputSelect() {
        List<Output> list=new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection = JdbcConn.getConnection();
            Scanner in = new Scanner(System.in);
            String sql = "select * from output ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Output output = new Output();
                output.setID(resultSet.getString(1));
                output.setName(resultSet.getString(2));
                output.setNum(resultSet.getInt(3));
                output.setSell_price(resultSet.getInt(4));
                output.setDate_out(resultSet.getString(5));
                list.add(output);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(preparedStatement!=null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(resultSet!=null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void outputClear() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection = JdbcConn.getConnection();
            String sql="delete from output";
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
