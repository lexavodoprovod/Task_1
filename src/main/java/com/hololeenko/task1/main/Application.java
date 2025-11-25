package com.hololeenko.task1.main;

import com.hololeenko.task1.dao.StudentDAO;
import com.hololeenko.task1.dao.impl.StudentDAOImpl;
import com.hololeenko.task1.entity.Student;
import com.hololeenko.task1.factory.Factory;
import com.hololeenko.task1.factory.RegularStudentFactory;
import com.hololeenko.task1.service.StudentService;
import com.hololeenko.task1.service.impl.StudentServiceImpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {


        Factory factory = new RegularStudentFactory();
        StudentDAO studentDAO = new StudentDAOImpl();

        Student student = factory.registerStudent(1, "Hololeenko", 20);
        Student student1 = factory.registerStudent(2, "Kovalev", 14);
        Student student2 = factory.registerStudent(3, "Davidenko", 28);
        Student student3 = factory.registerStudent(4, "Lebenok", 18);

        List<Student> students = studentDAO.loadStudents();//{student, student1, student2, student3};

        StudentService studentService = new StudentServiceImpl();
//        System.out.println(students.length);
//
//        studentService.findMaxAgeForStudent(students);
    }
}
