package com.github.brudijoe.session;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for afternoon sesion.
 */
public class AfternoonSessionTest {

    private AfternoonSession afternoonSession;

    @BeforeEach
    public void setUp() {
        afternoonSession = new AfternoonSession();
    }

    @Test
    public void testAddNetworkingEvent() {
        // Set duration to 0, so that networking event can be added
        afternoonSession.setDuration(0);

        afternoonSession.addNetworkingEvent();

        assertEquals(1, afternoonSession.getTalks().size(), 0, "size should be 1");
    }

    @Test
    public void testAddNetworkingEventShouldNotAddTalk() {
        afternoonSession.addNetworkingEvent();

        assertEquals(0, afternoonSession.getTalks().size(), 0, "size should be 0");
    }

}
