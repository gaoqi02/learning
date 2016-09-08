package sohu.test.xml2String;

import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;

/**
 * Created by qigao212074 on 2016/8/30.
 */
public class GetXml {

    private String fileUrl=null;
    public String getFileUrl() {
        return fileUrl;
    }
    public GetXml(String file) {
        this.fileUrl=GetXml.getPath(file);
    }
    /**
     * 获得项目所在路径
     * @return String
     */
    public static String getPath(String filename) {
        URL url = GetXml.class.getResource("");
        File file = new File(url.getFile());
        String path = file.getParent();
//        while (-1 != path.lastIndexOf("bin") || -1 != path.lastIndexOf(".jar")) {
//            file = new File(path);
//            path = file.getParent();
//        }
//        if (path.startsWith("file")) {
//            path = path.replaceAll("file:", "");
//        }

//        path = path + File.separator + "imp\\"+filename;
        path="D:\\pom.xml";
        return path;
    }
    public org.jdom.Document load(){
        org.jdom.Document document=null;
        String url=this.getFileUrl();
        try {
            SAXBuilder reader = new SAXBuilder();
            document=reader.build(new File(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
    public String XmlToString(){
        org.jdom.Document document=null;
        document=this.load();

        Format format =Format.getPrettyFormat();
        format.setEncoding("UTF-8");//设置编码格式

        StringWriter out=null; //输出对象
        String sReturn =""; //输出字符串
        XMLOutputter outputter =new XMLOutputter();
        out=new StringWriter();
        try {
            outputter.output(document,out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sReturn=out.toString();
        return sReturn;
    }

    public static void main(String[] args) {
        String strXml=null;
        GetXml xml=new GetXml("General.xml");
        strXml=xml.XmlToString();

        System.out.print(strXml);
    }
}
