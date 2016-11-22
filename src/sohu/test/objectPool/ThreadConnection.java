package sohu.test.objectPool;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by qigao212074 on 2016/11/10.
 */
public class ThreadConnection  implements Runnable{
    JDBCConnectionPool pool;
    @Override
    public void run() {
        // Do something...

        // Create the ConnectionPool:
        pool = new JDBCConnectionPool(
                "org.apache.hive.jdbc.HiveDriver", "jdbc:hive2://10.2.216.33:10000",
                "", "");

        // Get a connection:
        Connection con = pool.checkOut();
        ResultSet set = null;
        try {
            set = con.createStatement().executeQuery("show tables");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());

        // Use the connection

        // Return the connection:
        pool.checkIn(con);
    }

    public Connection getConnection() {
        Connection conn = null;
        if (pool != null) {
            conn = pool.checkOut();
        }
        return conn;
    }
}
