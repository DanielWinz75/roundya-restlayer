package net.roundya.restlayer.place;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Places")
public class Place {
    @Id
    private String _id;

    @Field(value = "Subject")    
    private String subject;

    @Field(value = "Predicate")    
    private String predicate;

    @Field(value = "Object")    
    private String object;    

    @Field(value = "Text")    
    private String text;

    @Field(value = "Location")    
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    public String getId() {
        return _id;
    }    

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    } 

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }   

}