package com.github.brudijoe.session;

import java.util.HashSet;
import com.github.brudijoe.talk.Talk;

/**
 * Session class.
 */
public class Session {

    private static final int SESSION_DURATION = 300;
    private HashSet<Talk> talks;

    public Session() {
        talks = new HashSet<Talk>();
    }


    public HashSet<Talk> getTalks() {
        return this.talks;
    }

    public void setTalks(HashSet<Talk> talks) {
        this.talks = talks;
    }

    public static int getSessionDuration() {
        return SESSION_DURATION;
    }

    public void addTalk(Talk talk) {
        talks.add(talk);
    }

    public HashSet<Talk> sortTalksIntoSession(HashSet<Talk> hashSet) {
        printSession(hashSet);
        return hashSet;
    }

    public void printSession(HashSet<Talk> hashSet) {
        for (Talk talk : hashSet) {
            System.out.println("Talk Title: " + talk.getName() + ", Duration: " + talk.getDuration()
                    + " minutes");
        }
    }

}
