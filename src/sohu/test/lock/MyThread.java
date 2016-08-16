package sohu.test.lock;

/**
 * Created by qigao212074 on 2016/8/15.
 */
class MyThread extends Thread {
    private TestLockInterruptibly test = null;
    public MyThread(TestLockInterruptibly test) {
        this.test = test;
    }
    @Override
    public void run() {

        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断");
        }
    }
}
