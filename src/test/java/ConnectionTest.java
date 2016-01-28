import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by faust on 28.01.16.
 */
public class ConnectionTest {

    @Test
    public void tryToConnect () throws IOException {
        URL url = new URL("http://kasino-vulkan-slot.com//soc-mob-ent");
        String test = "Does not work!";
        //String test = url.openConnection().getHeaderField(null);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects( false );
        test = httpURLConnection.getURL()+" *** "+
                httpURLConnection.getResponseCode()+" *** "+httpURLConnection.getHeaderField( "Location" );
        System.out.println(test);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
