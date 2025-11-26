package com.hololeenko.task1.entity;


public class RegularStudent extends Student{


    public RegularStudent(long id, String lastName, int age) {
        super(id, lastName, age);
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(getId());
        sb.append(", lastName='").append(getLastName()).append('\'');
        sb.append(", age=").append(getAge());
        sb.append('}');
        return sb.toString();
    }
}
