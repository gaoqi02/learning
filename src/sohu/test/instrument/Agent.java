package sohu.test.instrument;

import java.lang.instrument.Instrumentation;

/**
 * Created by qigao212074 on 2016/8/8.
 */
public class Agent {

    public static void premain(String args, Instrumentation inst){
        System.out.println("Hi, I'm agent!");
        inst.addTransformer(new TestTransformer());
    }
}
