package net.roundya.restlayer.configprovider;

import java.util.List;

import net.roundya.restlayer.place.PlaceConstants;

public class ProvidedConfigs {

    private List<String> predicates = PlaceConstants.PREDICATES;

    public List<String> getPredicates() {
        return this.predicates;
    }

    public void setPredicates(List<String> predicates) {
        this.predicates = predicates;
    }

}