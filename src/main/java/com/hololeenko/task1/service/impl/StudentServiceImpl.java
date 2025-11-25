package com.hololeenko.task1.service.impl;

import com.hololeenko.task1.entity.RegularStudent;
import com.hololeenko.task1.entity.Student;
import com.hololeenko.task1.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentServiceImpl implements StudentService {

    Logger logger = LogManager.getLogger(StudentServiceImpl.class);

    @Override
    public int findMaxAgeForStudent(Student[] students) {
//        for(int i = 0; i < students.length - 1; i++){
//            for(int j = 0; j < students.length - i - 1; j++){
//                if(students[j].getAge() > students[j + 1].getAge()){
//                    int temp = students[j].getAge();
//                   students[j].setAge(students[j + 1].getAge());
//                   students[j + 1].setAge(temp);
//                }
//            }
//        }
//
//        int maxAge = students[students.length - 1].getAge();
//        logger.info("Max Age for student is {}", maxAge);

        return 1;
    }

    @Override
    public int findMinAgeForStudent(Student[] students) {
        return 0;
    }

    @Override
    public int findMaxStudentId(Student[] students) {
        return 0;
    }
}
