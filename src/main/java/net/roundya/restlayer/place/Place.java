package net.roundya.restlayer.place;

import java.util.Date;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.annotation.AccessType.Type;
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

    @Field(value = "Subject")
    private String subject;

    @Field(value = "Predicate")
    private String predicate;

    @Field(value = "Object")
    private String object;

    @Field(value = "Text")
    private String text;

    @Field(value = "OwnerId")
    private String ownerId;

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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String id) {
        this.ownerId = id;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

}