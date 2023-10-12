package com.github.brudijoe;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.github.brudijoe.conference.Conference;
import com.github.brudijoe.session.Session;
import com.github.brudijoe.talk.Talk;
import com.github.brudijoe.track.Track;

/**
 * Main class.
 */
public final class ConferenceTrackManagement {

    /**
     * The main method of the application.
     */
    public static void main(String[] args) {

        Conference conference = new Conference();
        Session morningSession = new Session(180, 180, 540, 540);
        Session afternoonSession = new Session(240, 240, 60, 60);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(
                    "Enter talk details e.g., 'Writing Fast Tests Against Enterprise Rails 60min' (or 'exit' to finish): ");
            System.out.println();
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                morningSession.addTalk(new Talk("12:00PM", "Lunch", 60));
                String formattedAfternoonSessionStartTime =
                        afternoonSession.getFormattedStartTime(afternoonSession.getStartTime());
                // Networking Event only starts at 04:00PM
                if (afternoonSession.getDuration() <= afternoonSession.getTotalDuration() - 60) {
                    afternoonSession.addTalk(
                            new Talk(formattedAfternoonSessionStartTime, "Networking Event", 0));
                }
                Track track = new Track(morningSession, afternoonSession);
                conference.addTrack(track);
                conference.printConference();
                break;
            }

            Pattern pattern = Pattern.compile("(\\D+)(\\s)(\\d+)");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String talkName = matcher.group(1);
                int duration = Integer.parseInt(matcher.group(3));

                if (duration > afternoonSession.getTotalDuration()) {
                    System.out.println("Error: Duration to large!");
                    break;
                }

                if (duration <= morningSession.getDuration()) {
                    morningSession.setDuration(morningSession.getDuration() - duration);
                    morningSession.setEndTime(morningSession.getStartTime() + duration);

                    String formattedMorningSessionStartTime =
                            morningSession.getFormattedStartTime(morningSession.getStartTime());
                    Talk morningSessionTalk =
                            new Talk(formattedMorningSessionStartTime, talkName, duration);
                    morningSession.addTalk(morningSessionTalk);

                    morningSession.setStartTime(morningSession.getEndTime());
                } else if (duration <= afternoonSession.getDuration()) {
                    afternoonSession.setDuration(afternoonSession.getDuration() - duration);
                    afternoonSession.setEndTime(afternoonSession.getEndTime() + duration);

                    String formattedAfternoonSessionStartTime =
                            afternoonSession.getFormattedStartTime(afternoonSession.getStartTime());
                    Talk afternoonSessionTalk =
                            new Talk(formattedAfternoonSessionStartTime, talkName, duration);
                    afternoonSession.addTalk(afternoonSessionTalk);

                    afternoonSession.setStartTime(afternoonSession.getEndTime());
                } else if (duration > morningSession.getDuration()
                        && duration > afternoonSession.getDuration()) {

                    // Add Lunch und Networking event
                    morningSession.addTalk(new Talk("12:00PM", "Lunch", 60));
                    String formattedAfternoonSessionStartTime =
                            afternoonSession.getFormattedStartTime(afternoonSession.getStartTime());
                    afternoonSession.addTalk(
                            new Talk(formattedAfternoonSessionStartTime, "Networking Event", 0));

                    // Close session
                    Track track = new Track(morningSession, afternoonSession);
                    conference.addTrack(track);
                    morningSession = new Session(180, 180, 540, 540);
                    afternoonSession = new Session(240, 240, 60, 60);

                    morningSession.setEndTime(morningSession.getStartTime() + duration);

                    // Begin session with current talk
                    Talk morningSessionTalk = new Talk("09:00AM", talkName, duration);
                    morningSession.addTalk(morningSessionTalk);

                    morningSession.setStartTime(morningSession.getEndTime());

                    if (duration > morningSession.getTotalDuration()) {
                        System.out.println("Error: Duration to large for morning session!");
                        break;
                    }

                    morningSession.setDuration(morningSession.getDuration() - duration);
                }

            } else {
                System.out.println(
                        "Invalid input format. Please enter talk details in the correct format.");
            }

        }
        scanner.close();
    }
}
