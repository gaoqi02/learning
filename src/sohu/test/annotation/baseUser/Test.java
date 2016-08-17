package sohu.test.annotation.baseUser;

/**
 * Created by qigao212074 on 2016/8/17.
 */

//注入注解作用于类上面
//可以通过反射 获取类的信息之后 获取得到这个注解的值
@UserNameAnnotations(value = "initphp")
public class Test {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
