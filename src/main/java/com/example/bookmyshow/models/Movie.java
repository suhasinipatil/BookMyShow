package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;

    @ManyToMany
    private List<Actor> actorList;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> featureList;

    private String language;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Genre> genreList;
}
