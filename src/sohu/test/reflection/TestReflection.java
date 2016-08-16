package sohu.test.reflection;

import java.lang.reflect.*;

/**
 * Created by qigao212074 on 2016/8/10.
 */
public class TestReflection {
    private String username;
    private String password;
    private int[] age;
    public void setUserName(String username) {
        this.username = username;
        }
    private void setPassWord(String password) {
        this.password = password;
        }
    public static void test01() throws ClassNotFoundException {
        Class c1 = TestReflection.class;
        Class c2 = Class.forName("sohu.test.reflection.TestReflection");
        //获取指定的包名
        String package01 = c1.getPackage().getName();
        String package02 = c2.getPackage().getName();
        System.out.println("package01 = " + package01);
        System.out.println("package02 = " + package02);
        //获取类的修饰符
        int mod = c1.getModifiers();
        String modifier = Modifier.toString(mod);
        System.out.println("modifier = " + modifier);
        //获取指定类的完全限定名
        String className = c1.getName();
        System.out.println("className = " + className);
        //获取指定类的父类
        Class superClazz = c1.getSuperclass();
        String superClazzName = superClazz.getName();
        System.out.println("superClazzName = " + superClazzName);
        //获取实现的接口
        Class[] interfaces = c1.getInterfaces();
        for (Class t : interfaces) {
            System.out.println("interfacesName = " + t.getName());
            }
        //获取指定类的成员变量
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            modifier = Modifier.toString(field.getModifiers()); //获取每个字段的访问修饰符
            Class type = field.getType(); //获取字段的数据类型所对应的Class对象
            String name = field.getName(); //获取字段名
            if (type.isArray()) { //如果是数组类型则需要特别处理
                String arrType = type.getComponentType().getName() +
                "[]";
                System.out.println("" + modifier + " " + arrType + " "
                        + name + ";");
                } else {
                System.out.println("" + modifier + " " + type + " " +
                        name + ";");
                }
            }
        //获取类的构造方法
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName(); //构造方法名
            modifier = Modifier.toString(constructor.getModifiers()); //获取访问修饰符
            System.out.println("" + modifier +" " + name + "(");
            Class[] paramTypes = constructor.getParameterTypes(); //获取构造方法中的参数
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                    }
                if (paramTypes[i].isArray()) {
                    System.out.println(paramTypes
                            [i].getComponentType().getName()+"[]");
                    } else {
                    System.out.print(paramTypes[i].getName());
                    }
                }
            System.out.println(");");
            }
        //获取成员方法
        Method[] methods = c1.getDeclaredMethods();
        for (Method method: methods) {
            modifier = Modifier.toString(method.getModifiers());
            Class returnType = method.getReturnType(); //获取方法的返回类型
            if (returnType.isArray()) {
                String arrType = returnType.getComponentType
                ().getName()+"[]";
                System.out.print(""+modifier+" " + arrType + " " +
                        method.getName() + "(");
                } else {
                System.out.print("" + modifier + " " +
                        returnType.getName() + " " + method.getName() + "(");
                }
            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                    }
                if (paramTypes[i].isArray()) {
                    System.out.println(paramTypes
                            [i].getComponentType().getName()+"[]");
                    } else {
                    System.out.print(paramTypes[i].getName());
                    }
                }
            System.out.println(");");
            }
        }
    public static void test02() throws InstantiationException,
    IllegalAccessException, SecurityException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException {
        //反射调用方法，可以通过Method类的invoke方法实现动态方法的调用
        //public Object invoke(Object obj, Object... args)
        //第一个参数代表对象
        //第二个参数代表执行方法上的参数
        //若反射要调用类的某个私有方法，可以在这个私有方法对应的Mehtod对象上先调用setAccessible(true)
        Class c1 = TestReflection.class;
        TestReflection t1 = (TestReflection) c1.newInstance(); //利用反射来创建类的对象
        System.out.println("username == " + t1.username);
        System.out.println("password == " + t1.password);
        Method method = c1.getDeclaredMethod("setUserName", String.class);
        method.invoke(t1, "Java反射的学习");
        System.out.println("username == " + t1.username);
        method = c1.getDeclaredMethod("setPassWord", String.class);
        method.setAccessible(true);
        method.invoke(t1, "反射执行某个Private修饰的方法");
        System.out.println("password == " + t1.password);
        }
    public static void main(String[] args) throws ClassNotFoundException,
    SecurityException, IllegalArgumentException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        test01();
//        test02();
        }
}
