package com.gxy.dao.impl;

import com.gxy.common.JdbcConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
   public int login(String username,String password){
       Connection connection=null;
       PreparedStatement preparedStatement=null;
       try {
            connection = JdbcConn.getConnection();
           String sql="select * from user where username=? and password=?";
            preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1,username);
           preparedStatement.setString(2,password);
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               System.out.println(username);
               return 1;
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
           if (preparedStatement!=null){
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }
       return -1;
   }
}
