import entity.Site;
import entity.SiteTracker;
import entity.Tracker;
import entity.rules.IRuller;
import entity.rules.Nofollow;
import entity.rules.RuleOne;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by faust on 28.01.16.
 */
public class ModelTest {
    ArrayList<SiteTracker> siteTrackers;
    @Before
    public void retreiveSites () {
        siteTrackers = new ArrayList<>();
        Site site = new Site(1,"https://habrahabr.ru/post/126169/");
        Tracker tracker = new Tracker();
        HashSet<IRuller> rules = new HashSet<>();
        rules.add(new RuleOne());
        rules.add(new Nofollow());
        tracker.setRules(rules);
        SiteTracker siteTracker = new SiteTracker(site,tracker);
        siteTrackers.add(siteTracker);
    }
    @Test
    public void mainTest(){
        new Model(siteTrackers).proceed();

    }
}
