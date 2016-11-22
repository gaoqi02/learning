import java.sql.DriverManager;

/**
 * Created by qigao212074 on 2016/11/18.
 */
public class test {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.apache.hive.jdbc.HiveDriver");//指定连接类型
    }
}
