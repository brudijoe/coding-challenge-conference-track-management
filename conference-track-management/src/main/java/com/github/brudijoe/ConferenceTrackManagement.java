package com.github.brudijoe;

import com.github.brudijoe.conference.Conference;
import com.github.brudijoe.session.AfternoonSession;
import com.github.brudijoe.session.MorningSession;
import com.github.brudijoe.talk.Talk;
import com.github.brudijoe.track.Track;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Scanner scanner = new Scanner(System.in);

        final int matchGroupString = 1;
        final int matchGroupDuration = 3;

        boolean planning = true;
        while (planning) {
            System.out.print(
                    "Enter talk e.g., 'Writing Fast Tests Against Enterprise Rails 60min' (or 'exit' to finish): ");
            System.out.println();
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                morningSession.addLunch();
                afternoonSession.addNetworkingEvent();
                Track track = new Track(morningSession, afternoonSession);
                conference.addTrack(track);
                conference.printConference();
                break;
            }

            Pattern pattern = Pattern.compile("(\\D+)(\\s)(\\d+)");
            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                System.out.println(
                        "Invalid input format. Please enter talk details in the correct format.");
            }

            String talkName = matcher.group(matchGroupString);
            int duration = Integer.parseInt(matcher.group(matchGroupDuration));

            if (duration > afternoonSession.getTotalDuration()) {
                System.out.println("Error: Duration to large!");
                planning = false;
            }

            if (duration <= morningSession.getDuration()) {
                morningSession.setDuration(morningSession.getDuration() - duration);
                morningSession.setEndTime(morningSession.getStartTime() + duration);

                String formattedMorningSessionStartTime = morningSession.getFormattedStartTime();
                Talk morningSessionTalk =
                        new Talk(formattedMorningSessionStartTime, talkName, duration);
                morningSession.addTalk(morningSessionTalk);

                morningSession.setStartTime(morningSession.getEndTime());
            } else if (duration <= afternoonSession.getDuration()) {
                afternoonSession.setDuration(afternoonSession.getDuration() - duration);
                afternoonSession.setEndTime(afternoonSession.getEndTime() + duration);

                String formattedAfternoonSessionStartTime =
                        afternoonSession.getFormattedStartTime();
                Talk afternoonSessionTalk =
                        new Talk(formattedAfternoonSessionStartTime, talkName, duration);
                afternoonSession.addTalk(afternoonSessionTalk);

                afternoonSession.setStartTime(afternoonSession.getEndTime());
            } else if (duration > morningSession.getDuration()
                    && duration > afternoonSession.getDuration()) {

                // Add Lunch und Networking event
                morningSession.addLunch();
                afternoonSession.addNetworkingEvent();

                // Close session
                Track track = new Track(morningSession, afternoonSession);
                conference.addTrack(track);
                morningSession = new MorningSession();
                afternoonSession = new AfternoonSession();

                morningSession.setEndTime(morningSession.getStartTime() + duration);

                // Begin session with current talk
                Talk morningSessionTalk = new Talk("09:00AM", talkName, duration);
                morningSession.addTalk(morningSessionTalk);

                morningSession.setStartTime(morningSession.getEndTime());

                if (duration > morningSession.getTotalDuration()) {
                    System.out.println("Error: Duration to large for morning session!");
                    planning = false;
                }

                morningSession.setDuration(morningSession.getDuration() - duration);
            }

        }
        scanner.close();
    }
}
