package entity;

/**
 * Created by faust on 28.01.16.
 */
public class Site {
    private int id;
    private String urlStr;

    public Site() {
    }

    public Site(int id, String urlStr) {
        this.id = id;
        this.urlStr = urlStr;
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
    }
}
