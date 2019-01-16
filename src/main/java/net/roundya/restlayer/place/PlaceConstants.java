package net.roundya.restlayer.place;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PlaceConstants {
    public static final double MAX_DISTANCE_KILOMETERS = 20000.0;

    public static final List<String> PREDICATES = new ArrayList<String>( Arrays.asList(
        "kaufe", "verkaufe", "suche", "biete", "benötige", "lade ein zu", "bezeuge", "wünsche",
        "kaufen", "verkaufen", "suchen", "bieten", "benötigen", "laden ein zu", "bezeugen", "wünschen"
    ));

    public static final List<String> SUBJECTS = new ArrayList<String>( Arrays.asList(
        "Ich", "Wir"
    ));
}
