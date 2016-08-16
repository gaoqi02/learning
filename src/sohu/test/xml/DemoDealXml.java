package sohu.test.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * Created by qigao212074 on 2016/8/10.
 */
public class DemoDealXml  {

    public void createXml(String fileName) {
        //创建文档对象
        Document document = DocumentHelper.createDocument();
        //添加元素，第一个元素为根元素
        Element employees = document.addElement("employees");
        //在根元素下添加其它元素
        Element employee = employees.addElement("employee");
        //为元素添加数据(第一个参数为属性名称，第二个参数为属性值)
        employee.addAttribute("dept", "sale");

        Element name = employee.addElement("name");
        //设置该元素的文本值
        name.setText("andrew");

        Element sex = employee.addElement("sex");
        sex.setText("m");

        Element age = employee.addElement("age");
        age.setText("29");

        try {
            //创建写XML文档的Writer对象
            Writer fileWriter = new FileWriter(fileName);
            //创建美化文档的format对象，如果没有这个对象，生成的XML文档的元素不会换行，不太美观
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(fileWriter, format);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parserXml(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputXml);
            //获取文档的根元素
            Element employees = document.getRootElement();

            parseElement(employees);
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("dom4j parserXml");
    }


    @SuppressWarnings("unchecked")
    private void parseElement(Element element) {
        System.out.println("元素名:" + element.getName());

        //获得该元素的所有属性
        List attributes = element.attributes();
        for (int i = 0; i < attributes.size(); i++) {
            Attribute arrribute = (Attribute)attributes.get(i);
            //获得属性名
            String name = arrribute.getName();
            //获得属性值
            String value = arrribute.getValue();
            System.out.println("属性" + name + "的值:" + value);
        }

        //获得元素的文本的值，并且去掉空格
        String text = element.getTextTrim();
        if (text != null && text.length() > 0) {
            System.out.println("元素的文本值:" + text);
        }

        //获得元素下的所有子元素，递归调用以获取子元素下的属性及元素信息
        List childElements = element.elements();
        for (int i = 0; i < childElements.size(); i++) {
            Element childElement = (Element)childElements.get(i);
            parseElement(childElement);
        }
    }

    public static void main(String[] args) {
        DemoDealXml demo = new DemoDealXml();
        String fileName1 = DemoDealXml.class.getResource("example.xml").getPath();
        demo.parserXml(fileName1);
        String fileName2 = DemoDealXml.class.getResource("").getPath() + "example3.xml";
        demo.createXml(fileName2);
    }
}
