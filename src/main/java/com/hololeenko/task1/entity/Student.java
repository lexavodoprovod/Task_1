package com.hololeenko.task1.entity;

public abstract class Student {
    private long id;

    private String lastName;

    private int age;

    public Student(long id, String lastName, int age) {
        this.id = id;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return id == student.id && age == student.age && lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result * (age + result);
        result = 31 * result + age;
        return result;
    }
}
