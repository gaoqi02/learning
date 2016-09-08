package sohu.test.createDirAndFile;

import java.io.*;

/**
 * Created by qigao212074 on 2016/8/30.
 */
public class CreateFile {

    public static void main(String[] args) {
        String xml = "dadasdasdasdasd";
        byte[] bytexml = xml.getBytes();

        try {
            OutputStream os = new FileOutputStream(new File("D:\\rt\\test.txt"));
            os.write(bytexml);
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writeStrToFile("asdasdasdas");
    }

    public static void writeStrToFile(String xml){
        try {
            FileOutputStream fos =
                    new FileOutputStream(new File("D:\\tr\\rt\\test.txt"));
            Writer os = new OutputStreamWriter(fos, "GBK");
            os.write(xml);
            os.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void createFile(){

        //path表示你所创建文件的路径
        String path = "d:/tr/rt";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        // fileName表示你创建的文件名；为txt类型；
        String fileName="test.txt";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
        // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
