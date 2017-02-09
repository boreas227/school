package com.allstate.repositories;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ITeacherRepository extends CrudRepository<Teacher, String> {
    public Teacher findByName(String name);
    public ArrayList<Teacher> findByGender(Gender gender);
    public ArrayList<Teacher> findByAgeGreaterThan(int age);
    public ArrayList<Klass> findByTeacher(Teacher teacher);
    public Teacher findTeacherByClass(Klass klass);
}
