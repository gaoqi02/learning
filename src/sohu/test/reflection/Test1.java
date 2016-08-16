package sohu.test.reflection;

/**
 * Created by qigao212074 on 2016/8/16.
 */
public class Test1 implements Father{

    @Override
    public void hello() {
        execute();
        System.out.print("helloTest1");

    }

    @Override
    public void execute() {
        System.out.print("execute1");
    }
}
