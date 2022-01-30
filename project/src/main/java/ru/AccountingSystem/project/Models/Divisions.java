package ru.AccountingSystem.project.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "Divisions")
public class Divisions implements Serializable {

    @Id
    @GeneratedValue()
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Departments_id")
    @JsonManagedReference
    private Departments department;

    @JsonBackReference
    @OneToMany(mappedBy = "divisions",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Personnel> personnel;

    public Divisions() {
    }

    public Divisions(String name, Departments department) {
        this.name = name;
        this.department = department;
    }

    public Divisions(Long id, String name, Departments department) {
        this.id = id;
        this.name = name;
        this.department = department;
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

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public List<Personnel> getPersonnel() {
        return personnel;
    }

    public void setPersonnel(List<Personnel> personnel) {
        this.personnel = personnel;
    }
}
