package sohu.test.hook;

/**
 * Created by qigao212074 on 2016/11/16.
 */
public class TestExit {
    public static void main(String args){

        System.out.println("my java process");

//注册一个关机钩，当系统被退出或被异常中断时，启动这个关机钩线程

        Runtime.getRuntime().addShutdownHook(new Thread(){

            public void run(){

//添入你想在退出JVM之前要处理的必要操作代码

                System.out.println("T1");}

        });

//注册第二个关机钩

        Runtime.getRuntime().addShutdownHook(new Thread(){

            public void run(){ System.out.println("T2");}

        });

        System.exit(0);

    }

}
