package entity.rules;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by faust on 28.01.16.
 */
public class Nofollow implements IRuller{
    @Override
    public String executeRule() {
        String args[] = {"https://habrahabr.ru","soc-mob-ent"};
        System.out.println("Hello!");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("errors-log.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Document doc = null;

        try {
            doc = Jsoup.connect(args[0]).get();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

        assert doc != null;

        Elements links = doc.select("a");
        ArrayList pageUrls = new ArrayList();

        int i;
        for(i = 0; i < links.size(); ++i) {
            String e = links.get(i).attr("href");
            if(e.charAt(0) == 47 & e.length() > 1 & e.charAt(0) != 104 & !e.equals("/" + args[1])) {
                e = args[0] + e.substring(1, e.length());
                pageUrls.add(e);
            } else if(e.charAt(0) == 104) {
                pageUrls.add(e);
            }
        }

        for(i = 0; i < pageUrls.size(); ++i) {
            try {
                System.out.println("========================" + pageUrls.get(i));
                writer.println("\n========================" + pageUrls.get(i));
                doc = Jsoup.connect((String)pageUrls.get(i)).get();
                printNofollows(doc, args[1], writer);
            } catch (IOException var7) {
                var7.printStackTrace();
            }
        }

        writer.close();



        return null;
    }

    public static void printNofollows(Document doc, String htaccessRef, PrintWriter writer) {
        Elements aHref = doc.select("a[href=/" + htaccessRef + "]");
        new ArrayList();

        for(int i = 0; i < aHref.size(); ++i) {
            if(!aHref.get(i).attr("rel").toString().equals("nofollow")) {
                System.out.println(aHref.get(i) + "\n\n\t\t\t ---------------");
                writer.println(aHref.get(i) + "\n\n\t\t\t ---------------");
            }
        }

    }
}
