package com.hololeenko.task1.dao;

import com.hololeenko.task1.entity.RegularStudent;
import com.hololeenko.task1.entity.Student;

import java.util.List;

public interface StudentDAO {
    Student[] loadStudents();
}
