package com.github.brudijoe.talk;

/**
 * Lightning class.
 */
public class Lightning extends Talk {

    private static final int LIGHTNING_DURATION = 5;

    public Lightning(String startTime, String name) {
        super(startTime, name, LIGHTNING_DURATION);
    }

    public static int getLightningDuration() {
        return LIGHTNING_DURATION;
    }
}
