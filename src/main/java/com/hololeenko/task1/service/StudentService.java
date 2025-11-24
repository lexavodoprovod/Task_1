package com.hololeenko.task1.service;

import com.hololeenko.task1.entity.Student;

public interface StudentService {

    int findMaxAgeForStudent(Student[] students);
    int findMinAgeForStudent(Student[] students);
    int findMaxStudentId(Student[] students);
}
