package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {
    @Id
    @GeneratedValue
    private int id;
    @Version
    private int version;
    @NotNull
    private String name;
    @NotNull
    @Min(value=0)
    private int age;
    @Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date modified;
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private ArrayList<Klass> klasses;

    public Teacher() {}

    public Teacher(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
