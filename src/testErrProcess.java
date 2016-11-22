import java.io.IOException;

/**
 * Created by qigao212074 on 2016/8/5.
 */
public class testErrProcess {

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("HADOOP_PROXY_USER=platuser01 hadoop jar /home/testGao/jobFile/niuniu//1477471893849924120.jar JavaWordCount platuser01/job_design/RUN=NING.txt o1");
    }
}
