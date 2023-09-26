package com.github.brudijoe.session;

/**
 * MorningSession class.
 */
public class MorningSession extends Session {

    private boolean lunch;

    public MorningSession(boolean lunch) {
        this.lunch = lunch;
    }

    public boolean isLunch() {
        return this.lunch;
    }

}
