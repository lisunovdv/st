import entity.Site;
import entity.SiteTracker;
import entity.Tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faust on 28.01.16.
 */
public class Model {
    private ArrayList<SiteTracker> siteTrackers;

    public Model() {
    }

    public Model(ArrayList<SiteTracker> siteTrackers) {
        this.siteTrackers = siteTrackers;
    }

    public ArrayList<SiteTracker> getSiteTrackers() {
        return siteTrackers;
    }

    public void setSiteTrackers(ArrayList<SiteTracker> siteTrackers) {
        this.siteTrackers = siteTrackers;
    }

    public boolean proceed (){
        siteTrackers.forEach(SiteTracker::trackSite);
        return true;
    }

}
