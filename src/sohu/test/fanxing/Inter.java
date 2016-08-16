package sohu.test.fanxing;

/**
 * Created by qigao212074 on 2016/8/10.
 */
public interface Inter<T> {

    T show(T t) throws ClassNotFoundException;
}
