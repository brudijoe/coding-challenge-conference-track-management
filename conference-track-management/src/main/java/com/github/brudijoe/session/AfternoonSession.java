package com.github.brudijoe.session;

/**
 * AfternoonSession class.
 */
public class AfternoonSession extends Session {

    private boolean networkingEvent;

    public AfternoonSession(boolean networkingEvent) {
        this.networkingEvent = networkingEvent;
    }

    public boolean isNetworkingEvent() {
        return this.networkingEvent;
    }

}
