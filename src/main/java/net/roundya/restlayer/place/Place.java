package net.roundya.restlayer.place;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import net.roundya.restlayer.validation.ExpiresConstraint;
import net.roundya.restlayer.validation.PredicateConstraint;
import net.roundya.restlayer.validation.SubjectConstraint;

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

    @NotNull
    @ExpiresConstraint
    @Indexed(expireAfterSeconds = (int) PlaceConstants.TIME_TO_LIVE_MAX) // 3 hours = 10800, 3 days = 259200
    @Field(value = "ExpirationDate")
    private Date expires;

    @NotBlank
    @NotEmpty
    @NotNull
    @SubjectConstraint
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

    @Size(max = 300, message = "Text must not exeed 300 characters.")
    @Field(value = "Text")
    private String text;

    /**
     * username
     */
    @Field(value = "Owner")
    private String owner;

    @Field(value = "Url")
    @URL
    private String url;

    @NotNull
    @Field(value = "Location")
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    public void setDateCreated(Date d) {
        this.dateCreated = d;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getId() {
        return _id;
    }

    public void setExpires(String d) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            Date expDate = formatter.parse(d);
            this.expires = expDate;
        } catch (ParseException e) {
            this.expires = null;
        }
    }

    public Date getExpires() {
        return expires;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

}