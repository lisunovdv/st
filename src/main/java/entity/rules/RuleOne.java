package entity.rules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by faust on 28.01.16.
 */
public class RuleOne implements IRuller {
    @Override
    public String executeRule() {
        URL url = null;
        try {
            url = new URL("http://kasino-vulkan-slot.com//soc-mob-ent");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String test = "Does not work!";
        //String test = url.openConnection().getHeaderField(null);
        HttpURLConnection httpURLConnection = null;
        try {
            if (url != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (httpURLConnection != null) {
            httpURLConnection.setInstanceFollowRedirects( false );
        }
        try {
            if (httpURLConnection != null) {
                test = httpURLConnection.getURL()+" *** "+
                        httpURLConnection.getResponseCode()+" *** "+httpURLConnection.getHeaderField( "Location" );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(test);
        BufferedReader in = null;
        try {
            if (url != null) {
                in = new BufferedReader(
                        new InputStreamReader(url.openStream()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine;
        try {
                while ((inputLine = in != null ? in.readLine() : null) != null)
                System.out.println(inputLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
