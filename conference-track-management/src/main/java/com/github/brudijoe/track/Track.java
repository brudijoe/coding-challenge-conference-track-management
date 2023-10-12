package com.github.brudijoe.track;

import com.github.brudijoe.session.Session;

/**
 * Track class.
 */
public class Track {

    private Session morningSession;
    private Session afternoonSession;

    public Track(Session morningSession, Session afternoonSession) {
        this.morningSession = morningSession;
        this.afternoonSession = afternoonSession;
    }

    public Session getMorningSession() {
        return this.morningSession;
    }

    public void setMorningSession(Session morningSession) {
        this.morningSession = morningSession;
    }

    public Session getAfternoonSession() {
        return this.afternoonSession;
    }

    public void setAfternoonSession(Session afternoonSession) {
        this.afternoonSession = afternoonSession;
    }

    @Override
    public String toString() {
        return "{" + " morningSession='" + getMorningSession() + "'" + ", afternoonSession='"
                + getAfternoonSession() + "'" + "}";
    }


}
