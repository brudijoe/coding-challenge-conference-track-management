package com.github.brudijoe.talk;

/**
 * Talk class.
 */
public class Talk {

    private String name;
    private int duration;

    public Talk(String name, int duration) {
        this.name = name;
        this.duration = duration;
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
        return "{" + " name='" + getName() + "'" + ", duration='" + getDuration() + "'" + "}";
    }

}
