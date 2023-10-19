package com.github.brudijoe.session;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for morning session.
 */
public class MorningSessionTest {

    @Test
    public void testAddLunch() {
        MorningSession morningSession = new MorningSession();

        morningSession.addLunch();

        assertEquals(1, morningSession.getTalks().size());
    }

}
