package sohu.test.fanxing;

/**
 * Created by qigao212074 on 2016/8/10.
 */
class InterImpl<T> implements Inter<T> {

    public T show(T r) throws ClassNotFoundException {

        Class c2 = Class.forName(r.toString());
        System.out.println("show:"+r);

        return r;
    }

    public static void main(String[] args) {
    }

}
