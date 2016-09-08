package sohu.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by qigao212074 on 2016/8/31.
 */
public class Test {

    public static void main(String[] args) {
        System.out.print(findUnlockKey(-0000000000));
    }
    public static long findUnlockKey(long n) {
        Long num = Math.abs(n);
        String str = String.valueOf(num);
        String[] s = str.split("");

        Arrays.sort(s);

        if (n>=0) {
            int flag = 0;
            for (int i=0;i<s.length;i++) {
                if (!s[i].equals("0")) {
                    flag = i;
                    break;
                }
            }
            String tmp = "";
            tmp = s[0];
            s[0] = s[flag];
            s[flag] = tmp;

            StringBuffer stringBuffer = new StringBuffer("");
            for (String s1:s) {
                stringBuffer.append(s1);
            }
            return Integer.parseInt(stringBuffer.toString());
        } else {

            StringBuffer stringBuffer = new StringBuffer("");
            for (String s1:s) {
                stringBuffer.append(s1);
            }
            String str1 = stringBuffer.toString();
            char[] c = str1.toCharArray();
            int l = str1.length();
            for (int i = 0; i < l / 2; i++)
            {
                char t = c[i];
                c[i] = c[l - i - 1];
                c[l - i - 1] = t;
            }
            return Integer.parseInt(new String(c))*-1;

        }
    }
}
