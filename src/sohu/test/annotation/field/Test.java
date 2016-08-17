package sohu.test.annotation.field;

import sohu.test.annotation.baseUser.UserNameAnnotations;
import sohu.test.annotation.func.MethodType;

/**
 * Created by qigao212074 on 2016/8/17.
 */

//注入注解作用于类上面
//可以通过反射 获取类的信息之后 获取得到这个注解的值
@UserNameAnnotations(value = "initphp")
public class Test {

    @FieldAnnotations(value="zhuli")
    private String userName;

    //注解到
    @MethodType(methodType= MethodType.MethodTypeEnum.TYPE2)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
