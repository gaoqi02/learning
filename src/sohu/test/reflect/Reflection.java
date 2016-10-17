package sohu.test.reflect;
import net.vidageek.mirror.dsl.Mirror;

/**
 * Created by qigao212074 on 2016/9/8.
 */
public class Reflection {

    public static void main(String[] args) {
        //作业对象
        Object targetObject = new Test();
        //作业方法
        String jobMethod = "add";
        //执行作业
        Object[] trackNo = new Object[]{"q",3,"d"};
        new Mirror().on(targetObject).invoke().method(jobMethod).withArgs(trackNo);
    }
}
