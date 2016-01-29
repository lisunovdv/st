package entity.rules;

import entity.Site;

/**
 * Created by faust on 28.01.16.
 */
public abstract class Rule implements IRuller {
    protected String requestedStr;
    protected Site site;

    public String getRequestedStr() {
        return requestedStr;
    }

    public void setRequestedStr(String requestedStr) {
        this.requestedStr = requestedStr;
    }

    public Rule(Site site) {
        this.site = site;
        this.requestedStr = site.getParsedURL();// It's ugly, I know :(((((
    }
}
