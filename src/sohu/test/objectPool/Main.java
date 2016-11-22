package sohu.test.objectPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by qigao212074 on 2016/11/10.
 */
public class Main {
    public static void main(String args[]) throws SQLException, InterruptedException {
        ThreadConnection a = new ThreadConnection();
        ThreadConnection b = new ThreadConnection();
        ThreadConnection c = new ThreadConnection();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);

        t1.setPriority(10);
        t2.setPriority(10);
        t3.setPriority(10);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("线程A-> " + a.getConnection());
        System.out.println("线程B-> " + b.getConnection());
        System.out.println("线程C-> " + c.getConnection());

    }
}
