package com.github.brudijoe.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parsing regex.
 */
public class InputParser {

    private Pattern pattern = Pattern.compile("(\\D+)(\\s)(\\d+)");
    private final int matchGroupString = 1;
    private final int matchGroupDuration = 3;
    private Matcher matcher;

    /**
     * Parse console input and return a matcher.
     *
     * @param input The given input string.
     * @return Matcher.
     */
    public Matcher createInputMatcher(String input) {
        matcher = pattern.matcher(input);
        return matcher;
    }

    /**
     * The first group is usually the name of the talk.
     *
     * @return The talk name.
     */
    public String getMatcherName() {
        return matcher.group(matchGroupString);
    }

    /**
     * The third group is usualy the duration of the talk.
     *
     * @return The talk duration.
     */
    public int getMatcherDuration() {
        return Integer.parseInt(matcher.group(matchGroupDuration));
    }

}
