package sohu.test.lock;

/**
 * 1.syn 当一个线程获取了资源后，其他线程必须等待，但是lock  其他的线程可以Interrupt停止等待。
 * 2.lock最后一定要unlock()释放资源，不然资源一直被占用
 * 3.lock可以获取线程是否获取锁的状态，tryLock()
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
