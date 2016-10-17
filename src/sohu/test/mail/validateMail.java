package sohu.test.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qigao212074 on 2016/10/12.
 */
public class validateMail {


    public static String validator(List<String> mails) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 1; i < mails.size(); i++) {
            stringBuffer.append(checkEmail(mails.get(i))).append("\n");
        }
        return stringBuffer.toString();
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static String checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
            if (flag) {
                if (email.contains("qq")) return "Tencent";
                if (email.contains("sina")) return "Sina";
                if (email.contains("163")) return "Netease";
                if (email.contains("gmail")) return "Google";
                else return "Invalid";
            }
        } catch (Exception e) {
            return "Invalid";
        }
        return null;
    }

    //    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("47640123@qq.com");
//        list.add("47640123@sina.com");
//        list.add("47640123@163.com");
//        list.add("47640123@gmail.com");
//        list.add("47640123@dasdasd.com");
//        System.out.println(validator(list));
//    }
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int a = cin.nextInt();
        for (int i = 0; i <= a; i++) {
            list.add(cin.nextLine());

        }
        System.out.print(validator(list));
    }
}
