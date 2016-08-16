package sohu.test.reflection;

/**
 * Created by qigao212074 on 2016/8/16.
 */
public class TestMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("sohu.test.reflection.Test2");
        Father father = (Father)clazz.newInstance();
        father.hello();
    }
}
