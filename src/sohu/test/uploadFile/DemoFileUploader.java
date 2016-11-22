package sohu.test.uploadFile;


import java.io.File;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by qigao212074 on 2016/8/31.
 */
public class DemoFileUploader {

    public static void main(String args[]) throws Exception
    {
        DemoFileUploader fileUpload = new DemoFileUploader () ;
        File file = new File("C:\\Users\\qigao212074\\Desktop\\testAZKABAN\\test.job") ;
        //Upload the file
        fileUpload.executeMultiPartRequest("http://localhost:8080/bigdata-web/api/job_design/job/file",
                file, file.getName(), "File Uploaded :: Tulips.jpg") ;
    }

    public void executeMultiPartRequest(String urlString, File file, String fileName, String fileDescription) throws Exception
    {


        HttpClient client = new DefaultHttpClient() ;
        try {
            client = new SSLClient();
        } catch (Exception e) {
        }
        HttpPost postRequest = new HttpPost (urlString) ;
        try
        {
            //Set various attributes
            MultipartEntity multiPartEntity = new MultipartEntity () ;

            multiPartEntity.addPart("project", new StringBody("test6;type/plain")) ;
            multiPartEntity.addPart("session.id", new StringBody("e5055f20-0bab-4864-bc39-b1384bc04ca8")) ;

            FileBody fileBody = new FileBody(file, "application/zip") ;
            multiPartEntity.addPart("file", fileBody) ;
            //Prepare payload
//            multiPartEntity.addPart("attachment", fileBody) ;

            //Set to request body
            postRequest.setEntity(multiPartEntity) ;

            //Send request
            HttpResponse response = client.execute(postRequest) ;

            //Verify response if any
            if (response != null)
            {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace() ;
        }
    }

}
