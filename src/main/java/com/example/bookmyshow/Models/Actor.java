package com.example.bookmyshow.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Actor extends BaseModel{
    private String name;
}
