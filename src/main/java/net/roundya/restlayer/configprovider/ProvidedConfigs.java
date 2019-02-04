package net.roundya.restlayer.configprovider;

import java.util.List;

import net.roundya.restlayer.place.PlaceConstants;

public class ProvidedConfigs {

    private List<String> predicates = PlaceConstants.PREDICATES;

    private List<String> subjects = PlaceConstants.SUBJECTS;

    public List<String> getPredicates() {
        return this.predicates;
    }

    public void setPredicates(List<String> predicates) {
        this.predicates = predicates;
    }

    public List<String> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}