package com.allstate.entities;

import com.allstate.enums.Department;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "klasses")
@Data
public class Klass {
    @Id
    @GeneratedValue
    private int id;
    @Version
    private int version;
    @Size(min = 1)
    @NotNull
    private String name;
    @NotNull
    private Date semester;
    @NotNull
    @Min(value = 0)
    private int credits;
    @Column(columnDefinition = "ENUM('SCIENCE', 'ENGINEERING', 'LITERATURE', 'PHILOSOPHY')")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Department department;
    @DecimalMin(value = "0")
    @NotNull
    private double fee;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date modified;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Klass() {};

    public Klass(String name, Date semester, int credits, Department department, double fee) {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
        this.department = department;
        this.fee = fee;
    }
}
