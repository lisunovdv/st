package entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by faust on 28.01.16.
 *
 */
public class Site {
    private int id;
    private String urlStr;
    private URL url;
    private String parsedURL;

    public Site() {
    }

    public Site(int id, String urlStr) {
        this.id = id;
        this.urlStr = urlStr;
        prepare();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlStr() {
        return urlStr;
    }

    public void setUrlStr(String urlStr) {
        this.urlStr = urlStr;
        prepare();
    }

    public URL getUrl() {
        return url;
    }

    public String getParsedURL() {
        if (isPrepare()){
            return parsedURL;
        } else try {
            throw new IOException ("Can\'t GET page from URL: "+urlStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean prepare () {
        try {
            url = new URL(urlStr);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                parsedURL+=inputLine;
            in.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isPrepare(){
        return parsedURL!=null;
    }

}
