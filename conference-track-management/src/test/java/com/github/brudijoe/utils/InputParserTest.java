package com.github.brudijoe.utils;

import com.github.brudijoe.talk.Talk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test class for input parser.
 */
public class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    public void setUp() {
        inputParser = new InputParser();
    }

    @Test
    public void testParseTalk_ValidInput() {
        String input = "Sample Talk 45min";
        final int duration = 45;

        Talk talk = inputParser.parseTalk(input);

        assertEquals("Sample Talk", talk.getName());
        assertEquals(duration, talk.getDuration());
    }

    @Test
    public void testParseTalk_InvalidInput() {
        String input = "Invalid Input";

        Talk talk = inputParser.parseTalk(input);

        assertNull(talk);
    }

}
