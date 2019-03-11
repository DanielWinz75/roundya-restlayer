package net.roundya.restlayer.place;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PlaceConstants {
        public static final double MAX_DISTANCE_KILOMETERS = 20000.0;

        public static final long TIME_TO_LIVE_MIN = 3600; // seconds, 1 hour
        public static final long TIME_TO_LIVE_MAX = 259200; // seconds, 3 days

        public static final List<String> PREDICATES = new ArrayList<String>(
                        Arrays.asList("buy", "sell", "search", "offer", "need", "invite", "present"));

        public static final List<String> SUBJECTS = new ArrayList<String>(
                        Arrays.asList("singular", "plural"));

}
