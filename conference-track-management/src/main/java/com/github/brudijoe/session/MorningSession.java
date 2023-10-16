package com.github.brudijoe.session;

import com.github.brudijoe.talk.Talk;

/**
 * The morning session class extends the session class, to adjust to different duration and start
 * time.
 */
public class MorningSession extends Session {

    private static final int MORNING_SESSION_TOTAL_DURATION = 180;
    private static int morningSessionDuration = 180;
    private static int morningSessionStartTime = 540;
    private static int morningSessionEndTime = 540;
    private static int lunchDuration = 60;

    /**
     * Constructor for morning session.
     */
    public MorningSession() {
        super(MORNING_SESSION_TOTAL_DURATION, morningSessionDuration, morningSessionStartTime,
                morningSessionEndTime);
    }

    /**
     * Add a lunch slot after morning session.
     */
    public void addLunch() {
        Talk lunch = new Talk("12:00PM", "Lunch", lunchDuration);
        addTalk(lunch);
    }
}
