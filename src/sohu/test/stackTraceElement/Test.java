package sohu.test.stackTraceElement;

/**
 * Created by qigao212074 on 2016/8/16.
 */
public class Test {

    class TestM {
        public void OuterMethod(){
            new Test().methodA();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Test test = new Test();
        test.new TestM().OuterMethod();
    }


    public void methodA(){
        methodB();
    }

    public void methodB(){
        methodC();
    }

    public void methodC(){
//        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        for(StackTraceElement s: stacks){
            System.out.println("-------"+s.getMethodName()+" : "+s);
        }
    }
}
