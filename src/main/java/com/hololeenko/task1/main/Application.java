package com.hololeenko.task1.main;

import com.hololeenko.task1.dao.StudentDAO;
import com.hololeenko.task1.dao.impl.StudentDAOImpl;
import com.hololeenko.task1.entity.Student;
import com.hololeenko.task1.factory.StudentFactory;
import com.hololeenko.task1.factory.RegularStudentFactory;
import com.hololeenko.task1.service.StudentService;
import com.hololeenko.task1.service.impl.StudentServiceImpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {


        StudentFactory factory = new RegularStudentFactory();
        StudentDAO studentDAO = new StudentDAOImpl();
        StudentService studentService = new StudentServiceImpl();



        Student[] students = studentDAO.loadStudents();


        studentService.findMaxAgeForStudent(students);
    }
}
