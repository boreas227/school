package com.allstate.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Version
    private int version;
    @Email
    private String email;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date modified;

    public Student () {};

    public Student (String email) {
        this.email = email;
    }
}