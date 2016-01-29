import entity.Site;
import entity.SiteTracker;
import entity.Tracker;
import entity.rules.IRuller;
import entity.rules.Nofollow;
import entity.rules.NofollowRule;
import entity.rules.RuleOne;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by faust on 28.01.16.
 */
public class ModelTest {
    public static final String TESTED_SITE = "http://google.com/";
    //public static final String TESTED_SITE = "https://habrahabr.ru/post/126169/";
    //public static final String TESTED_SITE = "http://wp-test441.com/";
    ArrayList<SiteTracker> siteTrackers;
    @Before
    public void retreiveSites () throws IOException {
        siteTrackers = new ArrayList<>();
        Site site = new Site(1,TESTED_SITE);
        Tracker tracker = new Tracker();
        HashSet<IRuller> rules = new HashSet<>();
//        rules.add(new RuleOne());
//        rules.add(new Nofollow());
        rules.add(new NofollowRule(site));
        tracker.setRules(rules);
        SiteTracker siteTracker = new SiteTracker(site,tracker);
        siteTrackers.add(siteTracker);
    }


    @Test
    public void mainTest(){
        new Model(siteTrackers).proceed();

    }
}
