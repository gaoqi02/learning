package sohu.test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by qigao212074 on 2016/8/9.
 */
public class UserDAOProxy implements InvocationHandler {

    private Object target;
    private String bStr;
    private String aStr;

    public String getbStr() {
        return bStr;
    }

    public void setbStr(String bStr) {
        this.bStr = bStr;
    }

    public String getaStr() {
        return aStr;
    }

    public void setaStr(String aStr) {
        this.aStr = aStr;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public void beforeMethod(Method m) {
        System.out.println(m.getName()+" start...");
    }

    public void afterMethod(Method m) {
        System.out.println(m.getName()+" end...");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        beforeMethod(method);
//        method.invoke(target, args);
        afterMethod(method);
        return null;
    }
}
