package sohu.test.dynamicProxy;

import javax.annotation.Resource;

/**
 * Created by qigao212074 on 2016/8/9.
 */
public class UserService {

    private IUserDao userDao;

    public void add(User user)
    {
        userDao.save(user);
    }

    public IUserDao getUserDAO(){
        return userDao;
    }

    @Resource
    //@Autowired
    public void setUserDAO(IUserDao userDAO){
        this.userDao=userDAO;
    }
}
