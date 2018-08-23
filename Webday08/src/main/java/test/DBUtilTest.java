package test;

import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/*
*@ClassName:DBUtilTest
 @Description:TODO
 @Author:
 @Date:2018/8/22 9:24 
 @Version:v1.0
*/
public class DBUtilTest {
    public static void main(String[] args) throws SQLException {
        //test1();
        //test2();
        //test3();
        test4();

    }

    //连接使用完毕 关闭/归还连接
    private static void test4() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"waiting for conn");
                    try {
                        System.out.println(Thread.currentThread().getName()+DBUtil.getConnection());
                        System.out.println(Thread.currentThread().getName()+"get conn,over");
                        DBUtil.close();
                        System.out.println(Thread.currentThread().getName()+"close conn");
                        System.out.println(Thread.currentThread().getName()+DBUtil.getConnection());

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    //多线程获取连接 不关闭
    //连接泄露：一般在写dao层时候 连接使用完毕 不去关闭连接，造成程序运行一段时间以后，客户端的请求
    //得不到响应，原因在于：某些连接已经使用，但没有回收，数据库连接中的连接资源耗尽，新来的客户端获取不到
    //连接，会阻塞等待。
    private static void test3() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"waiting for conn");
                    try {
                        System.out.println(DBUtil.getConnection());
                        System.out.println(Thread.currentThread().getName()+"get conn,over");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
    //多线程获取连接
    private static void test2() {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(DBUtil.getConnection());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    //在同一个线程中   先后两次获取的连接时一样的
    private static void test1() throws SQLException {
        Connection connection = DBUtil.getConnection();
        Connection connection2 = DBUtil.getConnection();
        System.out.println(connection==connection2);
    }

}
