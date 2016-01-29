package entity.rules;

import entity.Site;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by faust on 28.01.16.
 */
public class NofollowRule extends Rule {
    public NofollowRule(Site site) {
        super(site);
    }

    @Override
    public String executeRule() {
        String result="";
        ArrayList<String> res = new ArrayList<>();
        Document doc = Jsoup.parse(requestedStr);
        Elements anchors = doc.select("a[href]:not([rel='nofollow'])");
        for (Element anchor :anchors) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("MyThread");
                    System.out.println(Thread.currentThread().getName()+"_"+
                            Thread.currentThread().getId()+" "+anchor.toString());
                    String linkURI = anchor.attr("href");
                    linkURI = substituteDomain(linkURI);
                    if (isMovedPermanently301(linkURI)){
//                        result+=("\n"+linkURI);
                        res.add(linkURI);
                        System.out.println("\t\t\t\t\t FIND: "+linkURI);
                    }
                }
            }).start();
        }
        //res.forEach(System.out::println); Uncomment this
        return result;
    }

    public int retrieveResponseCode (String urlStr) {
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        try {
            url = new URL(urlStr);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setInstanceFollowRedirects( false );
            return httpURLConnection.getResponseCode();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean isMovedPermanently301(String urlStr){
        return 301==retrieveResponseCode(urlStr);
    }

    private String substituteDomain (String link){
        if (link.charAt(0)=='/' | link.charAt(0)=='#') {
            link = site.getUrl().getProtocol()+"://"+site.getUrl().getHost()+link;
        }
        return link;
    }
}
