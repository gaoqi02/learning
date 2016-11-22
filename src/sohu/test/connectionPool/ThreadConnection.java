package sohu.test.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by qigao212074 on 2016/11/10.
 */
public class ThreadConnection implements Runnable {
    private IConnectionPool pool;

    @Override
    public void run() {
        pool = ConnectionPoolManager.getInstance().getPool("testPool");
        Connection connection = pool.getConnection();
        try {
            System.out.println(Thread.currentThread().getName());
            connection.createStatement().executeQuery("show tables");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        if (pool != null && pool.isActive()) {
            conn = pool.getConnection();
        }
        return conn;
    }

    public Connection getCurrentConnection() {
        Connection conn = null;
        if (pool != null && pool.isActive()) {
            conn = pool.getCurrentConnecton();
        }
        return conn;
    }
}
