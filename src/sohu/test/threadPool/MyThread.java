package sohu.test.threadPool;

/**
 * Created by qigao212074 on 2016/8/18.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }
}
