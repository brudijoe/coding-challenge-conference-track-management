package com.github.brudijoe.conference;

import java.util.ArrayList;
import com.github.brudijoe.talk.Talk;
import com.github.brudijoe.track.Track;

public class Conference {

    private ArrayList<Track> tracks;

    public Conference() {
        this.tracks = new ArrayList<Track>();
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public ArrayList<Track> getTracks() {
        return this.tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public void printConference() {
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println("Track " + (i + 1) + ":");
            for (Talk track : tracks.get(i).getMorningSession().getTalks()) {
                if (track.getName() == "Lunch") {
                    System.out.println(track.getStartTime() + " " + track.getName());
                } else {
                    System.out.println(track.getStartTime() + " " + track.getName() + " "
                            + track.getDuration() + "min");
                }
            }

            for (Talk track : tracks.get(i).getAfternoonSession().getTalks()) {
                if (track.getName() == "Networking Event") {
                    System.out.println(track.getStartTime() + " " + track.getName());
                } else {
                    System.out.println(track.getStartTime() + " " + track.getName() + " "
                            + track.getDuration() + "min");
                }
            }
            System.out.println();
        }
    }

}
