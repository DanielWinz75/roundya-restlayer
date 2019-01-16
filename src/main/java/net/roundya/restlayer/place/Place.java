package net.roundya.restlayer.place;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Document(collection = "Places")
public class Place {   

    @Id
    private String _id;

    @CreatedDate
    private Date dateCreated;

    @LastModifiedDate
    private Date lastUpdated;

    // TBD: Causes dub key exception, when updating (put) Document
    // Same prob here:
    // https://stackoverflow.com/questions/53242033/spring-boot-mongo-audit-version-issue
    // @Version
    // public long version;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 2, message = "Subject should have 2 characters at least.")    
    @Field(value = "Subject")
    private String subject;

    @NotBlank
    @NotEmpty
    @NotNull
    @PredicateConstraint
    @Size(min = 2, message = "Predicate should have 2 characters at least.")    
    @Field(value = "Predicate")
    private String predicate;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 2, message = "Object should have 2 characters at least.")    
    @Field(value = "Object")
    private String object;
    
    @Field(value = "Text")
    private String text;

    /**
     * username
     */
    @Field(value = "Owner")
    private String owner;

    @NotNull
    @Field(value = "Location")
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    public void setId(String id) {
        this._id = id;
    }

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String user) {
        this.owner = user;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

}