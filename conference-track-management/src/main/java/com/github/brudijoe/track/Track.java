package com.github.brudijoe.track;

import com.github.brudijoe.session.AfternoonSession;
import com.github.brudijoe.session.MorningSession;

/**
 * Track class.
 */
public class Track {

    private MorningSession morningSession;
    private AfternoonSession afternoonSession;

    /**
     * Contructor that takes a morning session and afternoon session.
     */
    public Track(MorningSession morningSession, AfternoonSession afternoonSession) {
        this.morningSession = morningSession;
        this.afternoonSession = afternoonSession;
    }

    public MorningSession getMorningSession() {
        return this.morningSession;
    }

    public void setMorningSession(MorningSession morningSession) {
        this.morningSession = morningSession;
    }

    public AfternoonSession getAfternoonSession() {
        return this.afternoonSession;
    }

    public void setAfternoonSession(AfternoonSession afternoonSession) {
        this.afternoonSession = afternoonSession;
    }

    @Override
    public String toString() {
        return "{" + " morningSession='" + getMorningSession() + "'" + ", afternoonSession='"
                + getAfternoonSession() + "'" + "}";
    }

}
