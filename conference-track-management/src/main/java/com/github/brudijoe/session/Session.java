package com.github.brudijoe.session;

import com.github.brudijoe.talk.Talk;
import java.util.ArrayList;

/**
 * Session class.
 */
public class Session {

    private ArrayList<Talk> talks;
    private int totalDuration;
    private int duration;
    private int startTime;
    private int endTime;
    private final int minutesInAnHour = 60;

    /**
     * Constructor for session.
     *
     * @param totalDuration The total duration of the session in minutes.
     * @param duration The duration of the session in minutes.
     * @param startTime The start time of the session in minutes.
     * @param endTime The end time of the session in minutes.
     */
    public Session(int totalDuration, int duration, int startTime, int endTime) {
        this.talks = new ArrayList<Talk>();
        this.totalDuration = totalDuration;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ArrayList<Talk> getTalks() {
        return this.talks;
    }

    /**
     * Format a string that match the requirements.
     *
     * @param morningSessionHours The starting hour in hours.
     * @param morningSessionMinutes The starting minutes in minutes.
     * @return A formatted string e.g. 09:00AM.
     */
    public String formatStartTime(int morningSessionHours, int morningSessionMinutes) {
        String format = "%02d:%02dAM";
        return String.format(format, morningSessionHours, morningSessionMinutes);
    }

    /**
     * Format a string, dependent on the given start time.
     *
     * @return A formatted string.
     */
    public String getFormattedStartTime() {
        int morningSessionHours = getStartTime() / minutesInAnHour;
        int morningSessionMinutes = getStartTime() % minutesInAnHour;
        return formatStartTime(morningSessionHours, morningSessionMinutes);
    }

    public void addTalk(Talk talk) {
        talks.add(talk);
    }

    public void setTalks(ArrayList<Talk> talks) {
        this.talks = talks;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

}
