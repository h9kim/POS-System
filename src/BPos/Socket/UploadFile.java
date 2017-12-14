package BPos.Socket;

/**
 *
 * @author Bhagya
 */
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

public class UploadFile {

    public static void upload() throws Exception {

        String userHome = System.getProperty("user.home");
        HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpPost httppost = new HttpPost("http://bpossystem.hoxty.com/Upload.php");
        File file = new File("C:\\Users\\Bhagya\\Desktop\\up\\b_pos.sql");
        MultipartEntity mpEntity = new MultipartEntity();
        ContentBody contentFile = new FileBody(file);
        mpEntity.addPart("userfile", contentFile);
        httppost.setEntity(mpEntity);
        System.out.println("executing request " + httppost.getRequestLine());
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();

        if (!(response.getStatusLine().toString()).equals("HTTP/1.1 200 OK")) {
            // Successfully Uploaded
        } else {
            // Did not upload. Add your logic here. Maybe you want to retry.
        }
        System.out.println(response.getStatusLine());
        if (resEntity != null) {
            System.out.println(EntityUtils.toString(resEntity));
        }
        if (resEntity != null) {
            resEntity.consumeContent();
        }
        httpclient.getConnectionManager().shutdown();
    }

    public static void main(String[] args) {
        try {
           
            long startTime = System.nanoTime();
             UploadFile.upload();
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);
            final double seconds = ((double)duration / 1000000000);
            System.out.println("Duration :- "+seconds);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
