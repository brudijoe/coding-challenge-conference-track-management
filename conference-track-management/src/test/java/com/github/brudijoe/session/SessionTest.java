package com.github.brudijoe.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.github.brudijoe.talk.Lightning;
import com.github.brudijoe.talk.Talk;

public class SessionTest {

    Session session;

    @BeforeEach
    public void setUp() {
        session = new Session();
    }

    @Test
    public void testSortTalksIntoSession() {

        // Create some Talk objects
        Talk talk1 = new Talk("Writing Fast Tests Against Enterprise Rails", 60);
        Talk talk2 = new Talk("Overdoing it in Python", 45);
        Talk talk3 = new Talk("Lua for the Masses", 30);
        Talk talk4 = new Talk("Ruby Errors from Mismatched Gem Versions", 45);
        Talk talk5 = new Talk("Common Ruby Errors", 45);
        Talk talk6 = new Talk("Communicating Over Distance", 60);
        Talk talk7 = new Talk("Accounting-Driven Development", 45);
        Talk talk8 = new Talk("Woah", 30);
        Talk talk9 = new Talk("Sit Down and Write", 30);
        Talk talk10 = new Talk("Pair Programming vs Noise", 45);
        Talk talk11 = new Talk("Rails Magic", 60);
        Talk talk12 = new Talk("Ruby on Rails: Why We Should Move On", 60);
        Talk talk13 = new Talk("Clojure Ate Scala (on my project)", 45);
        Talk talk14 = new Talk("Programming in the Boondocks of Seattle", 30);
        Talk talk15 = new Talk("Ruby vs. Clojure for Back-End Development", 30);
        Talk talk16 = new Talk("Ruby on Rails Legacy App Maintenance", 60);
        Talk talk17 = new Talk("A World Without HackerNews", 30);
        Talk talk18 = new Talk("User Interface CSS in Rails Apps", 30);

        // Create Lightning talk
        Lightning lightning1 = new Lightning("Rails for Python Developers");

        // Add talks to the session
        session.addTalk(talk1);
        session.addTalk(talk2);
        session.addTalk(talk3);
        session.addTalk(talk4);
        session.addTalk(talk5);
        session.addTalk(talk6);
        session.addTalk(talk7);
        session.addTalk(talk8);
        session.addTalk(talk9);
        session.addTalk(talk10);
        session.addTalk(talk11);
        session.addTalk(talk12);
        session.addTalk(talk13);
        session.addTalk(talk14);
        session.addTalk(talk15);
        session.addTalk(talk16);
        session.addTalk(talk17);
        session.addTalk(talk18);
        session.addTalk(lightning1);

        assertEquals("todo", "");
    }
}
