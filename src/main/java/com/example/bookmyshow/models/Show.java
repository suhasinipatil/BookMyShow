package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{
    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Auditorium auditorium;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> featureList;
}
