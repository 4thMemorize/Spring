package org.memorize.dbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;

@ContextConfiguration(locations = {"file:/web/WEB-INF/*.xml"})
public class MybatisTest {
    @Autowired
    private DataSource ds;

    public void testDs() throws Exception {
        try(Connection con = ds.getConnection()) {
            System.out.println("Success");
            System.out.println(con);
        } catch (Exception e) {e.printStackTrace();}
    }
}
