package com.github.brudijoe.session;

import java.util.ArrayList;
import com.github.brudijoe.talk.Talk;

/**
 * Session class.
 */
public class Session {

    private ArrayList<Talk> talks;
    private int totalDuration;
    private int duration;
    private int startTime;
    private int endTime;

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

    public String formatStartTime(int morningSessionHours, int morningSessionMinutes) {
        String format = "%02d:%02dAM";
        return String.format(format, morningSessionHours, morningSessionMinutes);
    }

    public String getFormattedStartTime(int startTime) {
        int morningSessionHours = startTime / 60;
        int morningSessionMinutes = startTime % 60;
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
