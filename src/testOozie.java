import org.apache.oozie.client.AuthOozieClient;
import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.OozieClientException;

import java.util.Properties;

/**
 * Created by qigao212074 on 2016/8/10.
 */
public class testOozie {

    public static void main(String[] args) {
        AuthOozieClient wc = new AuthOozieClient("http://10.2.216.33:11000/oozie");
//        OozieClient wc = new OozieClient("http://10.2.216.33:11000/oozie");
        Properties conf = wc.createConfiguration();
        //conf.setProperty(OozieClient.APP_PATH,"hdfs://192.168.1.133:9000"  + appPath);
        conf.setProperty("nameNode", "hdfs://10.2.216.33:9000");
        conf.setProperty("queueName", "default");
        conf.setProperty("examplesRoot", "examples");
        conf.setProperty("oozie.wf.application.path", "${nameNode}/user/root/examples/apps/map-reduce");
        conf.setProperty("outputDir", "map-reduce");
        conf.setProperty("jobTracker", "http://10.2.216.33:9001");
        conf.setProperty("inputDir", "");
        conf.setProperty("outputDir", "");

        try {
            String jobId = wc.run(conf);
            System.out.print(jobId);
        } catch (OozieClientException e) {

            e.printStackTrace();
        }
    }
}
