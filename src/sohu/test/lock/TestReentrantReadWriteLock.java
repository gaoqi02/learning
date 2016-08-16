package sohu.test.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * Created by qigao212074 on 2016/8/15.
 */
public class TestReentrantReadWriteLock {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args)  {
        final TestReentrantReadWriteLock test = new TestReentrantReadWriteLock();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

    }

    public synchronized void get1(Thread thread) {//使用syn则两个线程顺序执行
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start <= 1) {
            System.out.println(thread.getName()+"正在进行读操作");
        }
        System.out.println(thread.getName()+"读操作完毕");
    }

    public void get(Thread thread) {
        rwl.readLock().lock();//读锁，两个线程可以同时进行
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }
}
