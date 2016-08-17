package sohu.test.annotation.field;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by qigao212074 on 2016/8/17.
 */
public class MainTest {


    public static void main(String[] args) {
        Test test = new Test();
        Class<Test> testClass = Test.class;
        try {
            //因为是注解到Field上的，所以首先要获取这个字段
            Field field = testClass.getDeclaredField("userName");

            //判断这个Field上是否有这个注解
            if (field.isAnnotationPresent(FieldAnnotations.class)) {
                System.out.println("this is a field Annotation");

                //如果有这个注解，则获取注解类
                FieldAnnotations fieldAnnotations = (FieldAnnotations) field.getAnnotation(FieldAnnotations.class);
                if (fieldAnnotations != null) {
                    //通过反射给私有变量赋值
                    field.setAccessible(true);
                    field.set(test, fieldAnnotations.value());
                    System.out.println("value:" + test.getUserName());
                }
            } else {
                System.out.println("this is not  a field Annotation");
            }

        } catch (Exception e) {
        }

    }
}
