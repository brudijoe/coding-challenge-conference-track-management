package com.github.brudijoe.session;

import com.github.brudijoe.talk.Talk;

/**
 * The afternoon session class extends the session class, to adjust to different duration and start
 * time.
 */
public class AfternoonSession extends Session {

    private static final int AFTERNOON_SESSION_TOTAL_DURATION = 240;
    private static int afternoonSessionDuration = 240;
    private static int afternoonSessionStartTime = 60;
    private static int afternoonSessionEndTime = 60;
    private int minutesInAnHour = 60;

    /**
     * Constructor for afternoon session.
     */
    public AfternoonSession() {
        super(AFTERNOON_SESSION_TOTAL_DURATION, afternoonSessionDuration, afternoonSessionStartTime,
                afternoonSessionEndTime);
    }

    /**
     * Add a networking slot after afternoon session.
     */
    public void addNetworkingEvent() {
        // String formattedAfternoonSessionStartTime = getFormattedStartTime();
        String formattedAfternoonSessionStartTime =
                formatStartTime(calculateSessionHours(), calculateSessionMinutes());
        // Networking Event only starts at 04:00PM
        int earliestStartTime = getTotalDuration() - minutesInAnHour;
        if (getDuration() <= earliestStartTime) {
            addTalk(new Talk(formattedAfternoonSessionStartTime, "Networking Event", 0));
        }
    }

}
