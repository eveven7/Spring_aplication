package com.swedbank.StudentApplication.school.model;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table(name = "BUILDING")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @JsonIgnore

    @LazyCollection(LazyCollectionOption.FALSE)
    //deletes child student
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "building")
    List<ClassRoom> roomSet;

    public List<ClassRoom> getRoomSet() { return roomSet;
    }


}
