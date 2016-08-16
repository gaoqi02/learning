package sohu.test.dynamicProxy;

/**
 * Created by qigao212074 on 2016/8/9.
 */
public class User  {
    private String username;
    private String password;

    public String  getUsername()
    {
        return username;
    }

    public void setUsername(String name)
    {
        this.username = name;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String pwd){
        this.password = pwd;
    }
}
