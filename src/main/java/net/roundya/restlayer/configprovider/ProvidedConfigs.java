package net.roundya.restlayer.configprovider;

import java.util.List;

import net.roundya.restlayer.place.PlaceConstants;

public class ProvidedConfigs {

    private List<String> predicates = PlaceConstants.PREDICATES;
    private List<String> domains = PlaceConstants.DOMAINS;

    public List<String> getPredicates() {
        return this.predicates;
    }

    public void setPredicates(List<String> predicates) {}
    
    public List<String> getDomains() {
        return this.domains;
    }

    public void setDomains(List<String> domains) {}
}
