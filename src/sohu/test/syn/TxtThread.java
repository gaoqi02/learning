package sohu.test.syn;

import java.util.HashMap;

/**
 * Created by qigao212074 on 2016/8/16.
 */
class TxtThread implements Runnable {
    int num = 100;
    String str = new String();

    public void run() {
//        synchronized (str) {//对象锁，只有获取了当前的对象，只能有一个线程去操作这个tt对象，其他的需要等待
            while (num > 0) {

                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.getMessage();
                }
                System.out.println(Thread.currentThread().getName()
                        + "this is " + num--);
            }
//        }
    }

    public static void main(String[] args) {
        TxtThread tt = new TxtThread();
        new Thread(tt,"0").start();
        new Thread(tt,"1").start();
        new Thread(tt,"2").start();
        new Thread(tt,"3").start();
        HashMap<String,Integer> hashMap = new HashMap<>();
    }
}
