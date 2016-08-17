package sohu.test.annotation.field;

import java.lang.annotation.*;

/**
 * 定义到可以作用于域的注解
 * Created by qigao212074 on 2016/8/17.
 */
@Documented//文档
@Retention(RetentionPolicy.RUNTIME)//在运行时可以获取
@Target({ ElementType.FIELD })//作用到类的域上面
public @interface FieldAnnotations {

    public String value() default ""; //使用的时候 @FieldAnnotations(value="xxx")
}
