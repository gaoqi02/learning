package sohu.test.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by qigao212074 on 2016/8/9.
 */
public class TestProxy {
    public static void main(String[] args) {
        IUserDao userDAO = new UserDaoImple();  // 要使用动态代理，必须要先new一个被代理的对象（要不然代理代理什么呢？对吧）
        UserDAOProxy uDaoProxy = new UserDAOProxy(); // 使用动态代理也要new一个代理所要完成的业务逻辑
        uDaoProxy.setTarget(userDAO); //  这步算是绑定，将你想要的额外完成的东西与被代理对象联系起来

        IUserDao userDAOProxy = (IUserDao) Proxy.newProxyInstance(userDAO.getClass().getClassLoader(),
                userDAO.getClass().getInterfaces(), uDaoProxy); // 这步是创建代理对象了，第一个参数指定类加载器:使得这个代理类能访问被代理对象，第二个参数指定代理类应该具有哪些接口：要不然怎么去代理被代理对象（被代理对象所能做的，你代理也应该能完成，对不对？），第二个参数就是指定，代理对象额外完成的业务逻辑了：如前面所述的获取被代理类的执行时间。
        userDAOProxy.save(new User()); // 最后使用代理，代理具有被代理对象的所有方法，而且你还可以在被代理对象的方法执行前或执行后加上额外的业务逻辑。
    }
}

