package sohu.test.extend;

/**
 * Created by qigao212074 on 2016/8/9.
 */
public abstract class old<T> {

    public abstract  T execute();

    public int hello() {
        System.out.print(execute());
        return 1;
    }

    public static void main(String[] args) {
        System.out.print(new child1().execute());
    }
}
