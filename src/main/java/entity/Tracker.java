package entity;

import entity.rules.IRuller;

import java.util.HashSet;

/**
 * Created by faust on 28.01.16.
 */
public class Tracker implements ITrack {// It controls order of Rules execution
    private HashSet<IRuller> rules;

    public HashSet<IRuller> getRules() {
        return rules;
    }

    public void setRules(HashSet<IRuller> rules) {
        this.rules = rules;
    }

    @Override
    public String track(Site site) {
        rules.forEach(IRuller::executeRule);
        return "Tracked!";
    }
}
