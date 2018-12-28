package net.roundya.restlayer.task;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Tasks")
public class Task {
    @Id
    private String _id;

    @Field(value = "Description")    
    private String description;

    protected Task() { }

    public Task(String description) {
        this.description = description;
    }

    public String getId() {
        return _id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}