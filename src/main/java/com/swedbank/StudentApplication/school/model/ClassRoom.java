package com.swedbank.StudentApplication.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swedbank.StudentApplication.school.model.Building;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CLASS_ROOM")
@Data
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int floor;
    int capacity;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BUILDING_ID")
    Building building;
}