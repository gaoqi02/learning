package sohu.test.collectionUtils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import sohu.test.common.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by qigao212074 on 2016/8/16.
 */
public class Test {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        String chars = "aaaaaaaaaaaaaaaaaaaaa";
        System.out.println(chars.charAt((int)(Math.random() * 26)));

        for (int i =0; i<5 ; i++) {
            User user = new User((int)(Math.random() * 26),
                    String.valueOf(chars.charAt((int)(Math.random() * 12))));
            users.add(user);
        }

        HashSet<String> test = new Test().collect(users);
        System.out.print(":as");
    }

    private HashSet<String> collect(List<User> users) {
        HashSet<String> set = new HashSet<>(CollectionUtils.collect(users, new Transformer() {
            @Override
            public Object transform(Object o) {
                User u = (User) o;
                return u.getName();
            }
        }));
        return set;
    }

}
