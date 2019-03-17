package net.roundya.restlayer.place;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PlaceConstants {
        public static final double MAX_DISTANCE_KILOMETERS = 20000.0;

        public static final long TIME_TO_LIVE_MIN = 3000; // seconds, 50 min
        public static final long TIME_TO_LIVE_MAX = 10800; // 3 hours = 10800, 3 days = 259200

        public static final List<String> PREDICATES = new ArrayList<String>(
                        Arrays.asList("buy", "sell", "search", "offer", "need", "invite", "present"));

        public static final List<String> DOMAINS = new ArrayList<String>(
                        Arrays.asList(
                                "Messe Köln", 
                                "Südstadtfest", 
                                "Rock am Ring"));
        
        public static final List<String> SUBJECTS = new ArrayList<String>(Arrays.asList("singular", "plural"));

}
