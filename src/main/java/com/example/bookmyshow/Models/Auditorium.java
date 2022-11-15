package com.example.bookmyshow.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;

    @OneToMany
    private List<Seat> seatList;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> featureList;

}
