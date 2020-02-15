package com.blagoy.officemaps.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Document(collection = "Floor")
public class Floor {
    @Id
    private long id;

    @Field(value = "number")
    private long number;
    @NotNull
    @NotEmpty
    @Field(value = "objectMaps")
    private List<ObjectMap> objectMaps;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public List<ObjectMap> getObjectMaps() {
        return objectMaps;
    }

    public void setObjectMaps(List<ObjectMap> objectMaps) {
        this.objectMaps = objectMaps;
    }
}
