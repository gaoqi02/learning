package sohu.test.dynamicProxy;

/**
 * Created by qigao212074 on 2016/8/9.
 */
public class UserDaoImple implements IUserDao {

    @Override
    public void save(User user) {
        System.out.print("asd");
    }
}
