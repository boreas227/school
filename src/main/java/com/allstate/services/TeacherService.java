package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private ITeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher create(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    public Teacher findById(int id) {
        return this.teacherRepository.findOne("id");
    }

    public ArrayList<Teacher> findByGender(Gender gender) {
        return this.teacherRepository.findByGender(gender);
    }

    public ArrayList<Teacher> findByAgeGreaterThan(int age) {
        return this.teacherRepository.findByAgeGreaterThan(age);
    }

    public ArrayList<Klass> findByTeacher(Teacher teacher) {
        return this.teacherRepository.findByTeacher(teacher);
    }

    public Teacher findTecherByClass(Klass klass) {
        return this.teacherRepository.findTeacherByClass(klass);
    }

    public Teacher findByName(String name) {
        return this.teacherRepository.findByName(name);
    }
}
