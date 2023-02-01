//package com.blogms.util;
//
//import java.sql.*;
//
//public class JDBCTEST {
//    public static final String URL = "jdbc:mysql://localhost:3306/web_blog";
//    public static final String USER = "root";
//    public static final String PASSWORD = "114514";
//
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        //加载驱动类
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        //加载数据库连接
//        Connection coon = DriverManager.getConnection(URL, USER, PASSWORD);
//        System.out.println(coon);
//        String sql="INSERT INTO a_tag(tag_id,tag_name) VALUES (?,?)";  //定義SQL語句\
//
//        //创建preparedStatement装载SQL语句到达数据库
//        PreparedStatement pstmt= coon.prepareStatement(sql);
//        pstmt.setInt(1,20); //添加数据时使用把定义的变量转变为数据库数据
//
////        官方注释void setInt(int parameterIndex, int x) throws SQLException;
////        Sets the designated parameter to the given Java long value. The driver converts this to an SQL BIGINT value when it sends it to the database.
////        参数:
////        parameterIndex – the first parameter is 1, the second is 2, ...对应sql添加语句中的添加顺序
////        x – the parameter value  变量名
////        抛出:
////        SQLException – if parameterIndex does not correspond to a parameter marker in the SQL statement; if a database access error occurs or this method is called on a closed PreparedStatement
//
//        pstmt.setInt(2,2);
//        int i= pstmt.executeUpdate();  //检测增删改结果
//        if(i>0){
//            System.out.println("添加成功");
//        }else {
//            System.out.println("添加失败");
//
//        }
//    }
//
//}
