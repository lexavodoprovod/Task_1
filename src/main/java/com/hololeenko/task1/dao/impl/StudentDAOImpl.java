package com.hololeenko.task1.dao.impl;

import com.hololeenko.task1.dao.StudentDAO;
import com.hololeenko.task1.entity.Student;
import com.hololeenko.task1.exception.WrongFormatException;
import com.hololeenko.task1.factory.StudentFactory;
import com.hololeenko.task1.factory.RegularStudentFactory;
import com.hololeenko.task1.parser.Parser;
import com.hololeenko.task1.parser.impl.LineParserImpl;
import com.hololeenko.task1.parser.impl.StudentParserImpl;
import com.hololeenko.task1.validation.Validation;
import com.hololeenko.task1.validation.impl.LineValidationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private final String path;

    private final Logger logger;
    private Validation validation;
    private Parser lineParser;
    private Parser studentParser;
    private StudentFactory regStudFactory;

    public StudentDAOImpl() {
        path = "src/main/resources/students.txt";
        logger = LogManager.getLogger(StudentDAOImpl.class);
        validation = new LineValidationImpl();
        lineParser = new LineParserImpl();
        studentParser = new StudentParserImpl();
        regStudFactory = new RegularStudentFactory();
    }

    @Override
    public Student[] loadStudents() {

        List<Student> students = new ArrayList<>();
        Student[] studentArray = new Student[0];

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while((line = reader.readLine()) != null){

                String[] parts = lineParser.parse(line);

                List<String> studentsLine = validation.afterValidation(parts);

                for(String stud : studentsLine){
                    String[] studentParts = studentParser.parse(stud);

                    long id = Long.parseLong(studentParts[0]);
                    String name = studentParts[1];
                    int age = Integer.parseInt(studentParts[2]);

                    students.add(regStudFactory.registerStudent(id, name, age));

                    logger.info("Student with id {} has been registered", id);
                }



            }

            studentArray  = new Student[students.size()];

            for(int i = 0; i < students.size(); i++){
                studentArray[i] = students.get(i);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return studentArray;
    }
}
