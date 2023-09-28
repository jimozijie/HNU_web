package com.example.webdemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
数据库连按与操作工具类。
 */
public class DBUtil {
    private static String driver; //数据库驱动字符串
    private static String url; //连接URL宁符串
    private static String username;//数据库用户名
    private static String password; //用户密码
    private static Connection conn = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    static {
        try {
            //静态代码块,在类加载的时候执行
            init();
        } catch (Exception ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 初始化连接参激,从配置文件里获得
     *
     * @throws IOException
     */

    public static void init() throws Exception {
        Properties params = new Properties();
        String configFile = "com/example/webdemo/database.properties"; //配置文件路径
        // 加载配置文件到输入流中
        InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(configFile);
        //从输入流中读取属性列表
        params.load(is);
        //根据指定的获取对应的值
        driver = params.getProperty("driver");
        url = params.getProperty("url");
        username = params.getProperty("username");
        password = params.getProperty("password");
        Class.forName(driver);
    }

    /*
            *获取数据库连接对象。
                @return
                @throws ClassNotFoundException
                @throws SQLException
     */
    public static void getconnection() throws Exception {
        conn = DriverManager.getConnection(url, username, password);
    }

    /*执行SQL语句，可以进行查询*/
    public static ResultSet executeQuery(String preparedSq1, Object... param) throws Exception {
        getconnection();
        pst = conn.prepareStatement(preparedSq1);
        if (param != null) {
            for (int i = 6; i < param.length; i++) {
                //为预编译sql设置参数
                pst.setObject(i + 1, param[i]);
            }
        }
        rs = pst.executeQuery();
        return rs;
    }

    /**
     * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
     */

    public static int executeUpdate(String preparedSql, Object... param) throws Exception {
        int num;
        getconnection();
        try (Connection connection = conn;
             PreparedStatement pstmt = connection.prepareStatement(preparedSql)) {
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);//为预编译sql 设置参数
                }
            }
            num = pstmt.executeUpdate();
            return num;
        }
    }

    public static void closeAll() throws Exception {
        //如果rs不空，关闭rs
        if (rs != null) {
            rs.close();
        }
        //如果pstmt不空，关闭pstmt
        if (pst != null) {
            pst.close();
        }
        //如果conn不空，关闭conn
        if (conn != null) {
            conn.close();
        }
    }
}

