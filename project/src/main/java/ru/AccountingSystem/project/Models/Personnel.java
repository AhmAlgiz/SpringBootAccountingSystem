package ru.AccountingSystem.project.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "Personnel")
public class Personnel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String secondname;
    private String patronymic;
    private String post;
    private Long phonenumber;
    private String mail;

    @ManyToOne
    @JoinColumn(name = "Divisions_id")
    @JsonManagedReference
    private Divisions divisions;

    public Personnel() {
    }

    public Personnel(String name, String secondname, String patronymic, String post, Long phonenumber, String mail, Divisions divisions) {
        this.name = name;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.post = post;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.divisions = divisions;
    }

    public Personnel(Long id, String name, String secondname, String patronymic, String post, Long phonenumber, String mail, Divisions divisions) {
        this.id = id;
        this.name = name;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.post = post;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.divisions = divisions;
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

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Divisions getDivisions() {
        return divisions;
    }

    public void setDivisions(Divisions divisions) {
        this.divisions = divisions;
    }
}
