import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qigao212074 on 2016/8/5.
 */
public class TestProcess  {
    public static void main(String[] args) {
        BufferedReader br = null;
        Process process = null;
        List<String> commands = new ArrayList<String>();
//        commands.add("java D://testErrProcess");
        String command = "";
        BufferedReader bufferedReader = null;
        try {
            process = Runtime.getRuntime().exec(command);
            int test = process.waitFor();
            br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;
//            System.out.println("列出所有正在运行的进程信息：");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(process!=null){
                process.destroy();
            }
        }
    }


}
