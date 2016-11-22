package sohu.test.connectionPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qigao212074 on 2016/11/10.
 */
public class DBInitInfo {

    public  static List<DBbean> beans = null;
    static{
        beans = new ArrayList<DBbean>();
        // 这里数据 可以从xml 等配置文件进行获取
        // 为了测试，这里我直接写死
        DBbean beanOracle = new DBbean();
        beanOracle.setDriverName("org.apache.hive.jdbc.HiveDriver");
        beanOracle.setUrl("jdbc:hive2://10.2.216.33:10000");
        beanOracle.setUserName("");
        beanOracle.setPassword("");

        beanOracle.setMinConnections(5);
        beanOracle.setMaxConnections(100);

        beanOracle.setPoolName("testPool");
        beans.add(beanOracle);
    }
}
