package com.github.brudijoe;

import java.util.HashSet;
import com.github.brudijoe.session.Session;
import com.github.brudijoe.talk.Talk;

/**
 * Main class.
 */
public final class ConferenceTrackManagement {

    private ConferenceTrackManagement() {}

    /**
     * The main method of the application.
     */
    public static void main(String[] args) {
        Session session = new Session();

        // Create some Talk objects
        Talk talk1 = new Talk("Talk 1", 60);
        Talk talk2 = new Talk("Talk 2", 45);

        // Add talks to the session
        session.addTalk(talk1);
        session.addTalk(talk2);

        // Retrieve the talks from the session
        HashSet<Talk> sessionTalks = session.getTalks();

        // Print the talks
        for (Talk talk : sessionTalks) {
            System.out.println("Talk Title: " + talk.getName() + ", Duration: " + talk.getDuration()
                    + " minutes");
        }
    }
}
