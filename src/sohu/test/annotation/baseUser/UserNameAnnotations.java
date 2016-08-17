package sohu.test.annotation.baseUser;

import java.lang.annotation.*;

/**
 * 定义一个用户名的自定义注解
 * @author gaoqi
 * @date 2014-7-5
 */
@Documented //文档
@Retention(RetentionPolicy.RUNTIME) //在运行时可以获取
@Target({ ElementType.TYPE, ElementType.METHOD}) //作用到类，方法，接口上等
@Inherited //子类会继承
public @interface UserNameAnnotations {

    public String value() default ""; //使用的时候 @UserNameAnnotations(value="xxx")
}
