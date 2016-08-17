package sohu.test.annotation.func;

import java.lang.annotation.*;

/**
 * 定义到可以作用于方法的注解
 * Created by qigao212074 on 2016/8/17.
 */
@Documented//文档
@Retention(RetentionPolicy.RUNTIME)//在运行时可以获取
@Target({ ElementType.TYPE, ElementType.METHOD })//作用到类，方法，接口上等
public @interface MethodType {

    //枚举类型
    public enum MethodTypeEnum {
        TYPE1, TYPE2
    }

    //实际的值
    public MethodTypeEnum methodType() default MethodTypeEnum.TYPE1;
}
