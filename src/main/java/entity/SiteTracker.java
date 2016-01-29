package entity;

/**
 * Created by faust on 28.01.16.
 * // Chain Site and Tracker
 */
public class SiteTracker implements ISiteTracker{
    private Site site;
    private Tracker tracker;

    public SiteTracker() {
    }

    public SiteTracker(Site site, Tracker tracker) {
        this.site = site;
        this.tracker = tracker;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }


    @Override
    public void trackSite() {
        String result = tracker.track(site);
        System.out.println(result);
    }
}
