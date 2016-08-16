package sohu.test.syn;

/**
 * 尽管线程t1获得了对Inner的对象锁，但由于线程t2访问的是同一个Inner中的非同步部分。
 * 所以两个线程互不干扰。
 * 但是如果m4t2中也加入了syn锁，那么两个线程将顺序执行，因为t1获取Inner的对象锁，同步的m4t2方法也会被阻塞。
 * Created by qigao212074 on 2016/8/16.
 */
public class Thread4 {

    class Inner {
        private void m4t1() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {
                }
            }
        }
        private void m4t2() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {
                }
            }
        }
    }
    private void m4t1(Inner inner) {
        synchronized (inner) { //使用对象锁
            inner.m4t1();
        }
    }
    private void m4t2(Inner inner) {
        inner.m4t2();
    }
    public static void main(String[] args) {
        final Thread4 myt4 = new Thread4();
        final Inner inner = myt4.new Inner();
        Thread t1 = new Thread( new Runnable() {public void run() { myt4.m4t1(inner);} }, "t1");
        Thread t2 = new Thread( new Runnable() {public void run() { myt4.m4t2(inner);} }, "t2");
        t1.start();
        t2.start();
    }

}
