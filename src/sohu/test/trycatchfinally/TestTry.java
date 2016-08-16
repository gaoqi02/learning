package sohu.test.trycatchfinally;

/**
 * Created by qigao212074 on 2016/8/8.
 */
public class TestTry {

    public static void main(String[] args) {
        System.out.print(test());
    }

    public static String test() {
        try {
            System.out.print("try");

        } catch (Exception e) {
            System.out.print("exception");
        } finally {
            System.out.print("finally");
        }
        return "1231";

    }
}
