package com.github.brudijoe.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.github.brudijoe.talk.Talk;
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

        Talk talk = inputParser.parseTalk(input);

        assertEquals("Sample Talk", talk.getName());
        assertEquals(45, talk.getDuration());
    }

    @Test
    public void testParseTalk_InvalidInput() {
        String input = "Invalid Input";

        Talk talk = inputParser.parseTalk(input);

        assertNull(talk);
    }

}
