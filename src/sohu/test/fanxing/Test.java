package sohu.test.fanxing;

/**
 * Created by qigao212074 on 2016/8/10.
 */
public class Test {

    public static void test() throws ClassNotFoundException {
        Test t = new Test();
        InterImpl inter = new InterImpl();
        Test test = (Test) inter.show(t);
        System.out.print(test);
    }
    public static void main(String[] args) throws ClassNotFoundException {
        test();
    }
}
