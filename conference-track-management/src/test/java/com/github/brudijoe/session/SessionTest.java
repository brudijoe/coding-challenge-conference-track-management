package com.github.brudijoe.session;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.github.brudijoe.talk.Lightning;
import com.github.brudijoe.talk.Talk;

public class SessionTest {

    Session morningSession = new Session(180, 180, 540, 540);
    Session afternoonSession = new Session(240, 240, 60, 60);

    @BeforeEach
    public void setUp() {
        morningSession = new Session(180, 180, 540, 540);
        afternoonSession = new Session(240, 240, 60, 60);
    }

    @Test
    public void testSortTalksIntoSession() {

        // Create some Talk objects
        Talk talk1 = new Talk("", "Writing Fast Tests Against Enterprise Rails", 60);
        Talk talk2 = new Talk("", "Overdoing it in Python", 45);
        Talk talk3 = new Talk("", "Lua for the Masses", 30);
        Talk talk4 = new Talk("", "Ruby Errors from Mismatched Gem Versions", 45);
        Talk talk5 = new Talk("", "Common Ruby Errors", 45);
        Talk talk6 = new Talk("", "Communicating Over Distance", 60);
        Talk talk7 = new Talk("", "Accounting-Driven Development", 45);
        Talk talk8 = new Talk("", "Woah", 30);
        Talk talk9 = new Talk("", "Sit Down and Write", 30);
        Talk talk10 = new Talk("", "Pair Programming vs Noise", 45);
        Talk talk11 = new Talk("", "Rails Magic", 60);
        Talk talk12 = new Talk("", "Ruby on Rails: Why We Should Move On", 60);
        Talk talk13 = new Talk("", "Clojure Ate Scala (on my project)", 45);
        Talk talk14 = new Talk("", "Programming in the Boondocks of Seattle", 30);
        Talk talk15 = new Talk("", "Ruby vs. Clojure for Back-End Development", 30);
        Talk talk16 = new Talk("", "Ruby on Rails Legacy App Maintenance", 60);
        Talk talk17 = new Talk("", "A World Without HackerNews", 30);
        Talk talk18 = new Talk("", "User Interface CSS in Rails Apps", 30);

        // Create Lightning talk
        Lightning lightning1 = new Lightning("", "Rails for Python Developers");

    }

}
