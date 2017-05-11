package com.hive;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by qigao212074 on 2016/11/18.
 */
public class helloUDF extends UDF {

    public String evaluate(String str) {
        try {
            return "HelloWorld " + str;
        } catch (Exception e) {

            return null;

        }

    }

}
