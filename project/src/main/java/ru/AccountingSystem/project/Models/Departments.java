package ru.AccountingSystem.project.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "Departments")
public class Departments implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List <Divisions> divisions;

    public Departments() {
    }

    public Departments(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Divisions> getDivisions() {
        return divisions;
    }
}
