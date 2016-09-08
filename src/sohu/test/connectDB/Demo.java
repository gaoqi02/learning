package sohu.test.connectDB;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select * from project_properties";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象  

        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {
                Blob aa = ret.getBlob(5);
                String content ="";
                byte[] inbyte=null;
                try{
                    if (aa != null) {
                        inbyte = aa.getBytes(1, (int) aa.length());
                    }
                    content =new String (inbyte);
                } catch(SQLException e) {
                    e.printStackTrace();
                }
                System.out.print(content);
                String uid = ret.getString(1);
                String ufname = ret.getString(2);
                String ulname = ret.getString(3);
                String udate = ret.getString(4);
//                String udate = ret.getString(4);
            }//显示数据
            ret.close();
            db1.close();//关闭连接  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}  