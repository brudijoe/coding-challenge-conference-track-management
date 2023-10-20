package com.github.brudijoe.talk;

/**
 * Talk class.
 */
public class Talk {

    private String startTime;
    private String name;
    private int duration;

    /**
     * Constructor for talk with name and duration only.
     */
    public Talk(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    /**
     * Constructor for talk.
     */
    public Talk(String startTime, String name, int duration) {
        this.startTime = startTime;
        this.name = name;
        this.duration = duration;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return getName() + " " + getDuration() + "min";
    }

}
