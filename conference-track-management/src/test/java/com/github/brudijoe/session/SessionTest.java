package com.github.brudijoe.session;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for session.
 */
public class SessionTest {

    private Session session = new Session(180, 180, 540, 540);

    @Test
    public void testCalculateMorningSessionHours() {
        final int startingHours = 9;
        assertEquals(startingHours, session.calculateSessionHours(), 0, "Should be 9");
    }

    @Test
    public void testCalculateMorningSessionMinutes() {
        final int startingMinutes = 0;
        assertEquals(startingMinutes, session.calculateSessionMinutes(), 0, "Should be 0");
    }

    @Test
    public void testFormatStartTime() {
        final int startingHours = 9;
        final int startingMinutes = 0;
        assertEquals("09:00AM", session.formatStartTime(startingHours, startingMinutes),
                "Should be '09:00AM'");
    }

}
