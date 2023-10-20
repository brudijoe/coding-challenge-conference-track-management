package com.github.brudijoe;

import com.github.brudijoe.conference.Conference;
import com.github.brudijoe.session.AfternoonSession;
import com.github.brudijoe.session.MorningSession;
import com.github.brudijoe.talk.Talk;
import com.github.brudijoe.track.Track;
import com.github.brudijoe.utils.InputParser;
import java.util.Scanner;

/**
 * Main class.
 */
public final class ConferenceTrackManagement {

    private ConferenceTrackManagement() {}

    /**
     * The main method of the application.
     */
    public static void main(String[] args) {
        Conference conference = new Conference();
        MorningSession morningSession = new MorningSession();
        AfternoonSession afternoonSession = new AfternoonSession();
        InputParser inputParser = new InputParser();

        Scanner scanner = new Scanner(System.in);

        boolean planning = true;
        while (planning) {
            System.out.print(
                    "Enter talk e.g., 'Writing Fast Tests Against Enterprise Rails 60min' (or 'exit' to finish): ");
            System.out.println();
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                completeTrack(conference, morningSession, afternoonSession);
                break;
            }

            Talk talk = inputParser.parseTalk(input);

            if (talk == null) {
                System.out.println(
                        "Invalid input format. Please enter talk details in the correct format.");
            }

            if (talk.getDuration() > afternoonSession.getTotalDuration()) {
                System.out.println("Error: Duration to large!");
                planning = false;
            }


            if (talk.getDuration() <= morningSession.getDuration()) {
                handleMorningSessionTalk(morningSession, talk.getName(), talk.getDuration());
            } else if (talk.getDuration() <= afternoonSession.getDuration()) {
                handleAfternoonSessionTalk(afternoonSession, talk.getName(), talk.getDuration());
            } else if (talk.getDuration() > morningSession.getDuration()
                    && talk.getDuration() > afternoonSession.getDuration()) {
                // Add Lunch und Networking event
                morningSession.addLunch();
                afternoonSession.addNetworkingEvent();

                // Close session
                Track track = new Track(morningSession, afternoonSession);
                conference.addTrack(track);
                morningSession = new MorningSession();
                afternoonSession = new AfternoonSession();

                morningSession.setEndTime(morningSession.getStartTime() + talk.getDuration());

                // Begin session with current talk
                Talk morningSessionTalk = new Talk("09:00AM", talk.getName(), talk.getDuration());
                morningSession.addTalk(morningSessionTalk);

                morningSession.setStartTime(morningSession.getEndTime());

                if (talk.getDuration() > morningSession.getTotalDuration()) {
                    System.out.println("Error: Duration to large for morning session!");
                    planning = false;
                }

                morningSession.setDuration(morningSession.getDuration() - talk.getDuration());

            }
        }
        scanner.close();
    }

    private static void handleMorningSessionTalk(MorningSession morningSession, String talkName,
            int duration) {
        morningSession.setDuration(morningSession.getDuration() - duration);
        morningSession.setEndTime(morningSession.getStartTime() + duration);
        String formattedMorningSessionStartTime = morningSession.formatStartTime(
                morningSession.calculateSessionHours(), morningSession.calculateSessionMinutes());
        Talk morningSessionTalk = new Talk(formattedMorningSessionStartTime, talkName, duration);
        morningSession.addTalk(morningSessionTalk);
        morningSession.setStartTime(morningSession.getEndTime());
    }

    private static void handleAfternoonSessionTalk(AfternoonSession afternoonSession,
            String talkName, int duration) {
        afternoonSession.setDuration(afternoonSession.getDuration() - duration);
        afternoonSession.setEndTime(afternoonSession.getEndTime() + duration);
        String formattedAfternoonSessionStartTime =
                afternoonSession.formatStartTime(afternoonSession.calculateSessionHours(),
                        afternoonSession.calculateSessionMinutes());
        Talk afternoonSessionTalk =
                new Talk(formattedAfternoonSessionStartTime, talkName, duration);
        afternoonSession.addTalk(afternoonSessionTalk);
        afternoonSession.setStartTime(afternoonSession.getEndTime());
    }

    private static void completeTrack(Conference conference, MorningSession morningSession,
            AfternoonSession afternoonSession) {
        morningSession.addLunch();
        afternoonSession.addNetworkingEvent();
        Track track = new Track(morningSession, afternoonSession);
        conference.addTrack(track);
        conference.printConference();
    }

}
