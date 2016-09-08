package sohu.test.trycatchfinally.test;

/**
 * Created by qigao212074 on 2016/8/25.
 */
public class First {

    private static int test() {
        try {
            Second second = new Second();
            second.test();
        } catch (Exception e) {
            System.out.print("ads");
        }
        return 1;
    }

    public static void main(String[] args) {
        test();
    }
}
