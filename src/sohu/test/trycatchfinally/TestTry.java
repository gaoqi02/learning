package sohu.test.trycatchfinally;

/**
 * Created by qigao212074 on 2016/8/8.
 */
public class TestTry {

    public static void main(String[] args) {
        System.out.print(test());
    }

    public static String test() {
        String str = "asd";
        try {
            str += "!";
            throw new Exception();

        } catch (Exception e) {
            System.out.print(str);
        }
        return "1231";

    }
}
