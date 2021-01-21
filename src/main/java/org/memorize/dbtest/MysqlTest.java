package org.memorize.dbtest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlTest {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://mysql.cllddpufnmqr.ap-northeast-2.rds.amazonaws.com:3306/Spring";
    private static final String USER = "binu2893";
    private static final String PW = "4thMemorize";

    @Test
    public void connectionTest() throws Exception {
        Class.forName(DRIVER);

        try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
            System.out.println("Success");
            System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
