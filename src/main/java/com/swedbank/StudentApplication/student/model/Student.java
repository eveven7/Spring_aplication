package com.swedbank.StudentApplication.student.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="STUDENT")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="PERSONAL_NR")
    private long pnr;

    public long getPnr() {
        return pnr;
    }

    public void setPnr(long pnr) {
        this.pnr = pnr;
    }

    private String name;
    @Column(name="COUNTRY")
    private String country;

    private String surname;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public String country() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}