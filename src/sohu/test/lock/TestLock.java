package sohu.test.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qigao212074 on 2016/8/15.
 */
public class TestLock {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //这里的key是全局变量，当Thread0获得了，1就要等待
    public static void main(String[] args)  {
        final TestLock testLock = new TestLock();

        new Thread(){
            public void run() {
                testLock.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                testLock.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread) {
//        Lock lock = new ReentrantLock();//这里的锁是局部变量所以，Thread0,1可以同步执行。
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}
