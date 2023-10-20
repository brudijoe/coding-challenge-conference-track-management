package com.github.brudijoe.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.github.brudijoe.talk.Talk;

/**
 * Utility class for parsing input strings using regular expressions and extracting talk
 * information.
 */
public class InputParser {

    private Pattern pattern = Pattern.compile("(\\D+)(\\s)(\\d+)");
    private final int matchGroupString = 1;
    private final int matchGroupDuration = 3;

    /**
     * Parse the input string to extract talk information.
     *
     * @param input The input string representing a talk, e.g., "Writing Fast Tests Against
     *        Enterprise Rails 60min".
     * @return A Talk object representing the parsed talk information, or null if the input is
     *         invalid.
     */
    public Talk parseTalk(String input) {
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String talkName = matcher.group(matchGroupString);
            int duration = Integer.parseInt(matcher.group(matchGroupDuration));
            return new Talk(talkName, duration);
        } else {
            return null; // Invalid input
        }
    }

}
