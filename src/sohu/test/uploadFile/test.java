package sohu.test.uploadFile;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by qigao212074 on 2016/10/24.
 */
public class test {

    public static void main(String[] args) throws IOException {
        uploadTest();
    }

    public static void uploadTest() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:7012/test/local/file");
        FileBody fileBody = new FileBody(new File("d:\\word.txt"));
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        meBuilder.setCharset(Charset.defaultCharset());

        // meBuilder.addPart("files", fileBody);
        //meBuilder.addBinaryBody("files",new File("d:\\11.exe"));
        meBuilder.addBinaryBody("file", new File("C:\\Users\\qigao212074\\Desktop\\testAZKABAN\\test.job"));
        //meBuilder.addTextBody("fileName", "11.txt");

        HttpEntity httpEntity = meBuilder.build();
        httpPost.setEntity(httpEntity);
        System.out.println(httpEntity.getContentLength());
        //httpEntity.writeTo(new FileOutputStream("d:\\333.txt"));
        System.out.println(httpEntity.getContentType());

        HttpResponse response= httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity()));
        System.out.println();
    }


}
