package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        // TODO: Implement classifyEnergy()
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("BPM list cannot be null or empty");
        }

        int sum = 0;
        for (int bpm : bpms) {
            sum += bpm;
        }
        double avg = (double) sum / bpms.size();

        if (avg >= 140) {
            return "HIGH";
        } else if (avg >= 100) { // Covers 100–139
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        // TODO: Implement isValidTrackTitle()
        if (title == null) {
            return false;
        }

        if (title.length() < 1 || title.length() > 30) {
            return false;
        }

        for (char c : title.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false; // invalid character found
            }
        }

        return true; // valid
    }

    public static int normalizeVolume(int volumeDb) {
        // TODO: Implement normalizeVolume()
        if (volumeDb < 0) {
            return 0;
        } else if (volumeDb > 100) {
            return 100;
        } else {
            return volumeDb;
        }
    }
}
