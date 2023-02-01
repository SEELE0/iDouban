package com.blogms.util;

import java.io.IOException;
/*
 /* 连接数据库的具体操作
 * 相当于一个连接和关闭数据库的工具
 * 为了减少代码冗杂
 * 存放一些数据库的配置文件
 * */
import java.sql.*;
import java.util.Properties;

/**
 * @Description 数据库的连接和关闭工具
 */
public class JDBCUtil {

    /**
     * 获取数据库连接
     * 数据库的配置在配置文件中(db.properties)
     */
    //读取和处理资源文件中的信息
    static Properties pros = null;
//    public static final String URL = "jdbc:mysql://localhost:3306/web_blog?useUnicode=true&characterEncoding=utf8";
//    public static final String USER = "root";
//    public static final String PASSWORD = "114514";
    //加载JDBCUtil类的时候调用，static代码块只用一次
    static {
        pros = new Properties();
        try {
            //输入流读取资源文件
            pros.load(JDBCUtil.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("util------加载properties失败");
        }
    }

    /**
     * @return con
     * @Description 得到数据库连接
     */
    public static Connection getCon() {
        try {
            Class.forName(pros.getProperty("jdbcName")); //加载驱动类
//            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("util-----jdbcName寻找数据库连接失败");
        }
        Connection con;
        try {
            con = DriverManager.getConnection(pros.getProperty("db_URL"), pros.getProperty("db_User"), pros.getProperty("db_Password"));
//            con=DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println(con);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("util--------加载JDBCUtil失败");
            return null;
        }
    }


    /**
     * @param rs
     * @param st
     * @param con
     * @Description 关闭三个开关
     */
    public static void close(ResultSet rs, PreparedStatement st, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * @param st
     * @param con
     * @Description 关闭连接，关两个开关
     */
    public static void close(PreparedStatement st, Connection con) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param con
     * @Description 关闭一个连接的开关
     */
    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
//   //test
//    public static void main(String[] args) {
//        getCon();
//    }
}

