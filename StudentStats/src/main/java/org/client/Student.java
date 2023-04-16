package org.client;

import com.google.gson.Gson;

import java.util.*;

public class Student {
    private String name;
    private String surname;
    private Date birthDate;
    private String placeOfResidence;

    private List<Exam> passedExams;

    public Student(String name, String surname, Date birthDate, String placeOfResidence, List<Exam> passedExams) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.placeOfResidence = placeOfResidence;

        this.passedExams = passedExams;
    }

    public Student(String name, String surname, Date birthDate, String placeOfResidence) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.placeOfResidence = placeOfResidence;

        this.passedExams = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public List<Exam> getPassedExams() {
        return passedExams;
    }

    public void addExam(Exam e) {
        passedExams.add(e);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", placeOfResidence='" + placeOfResidence + '\'' +
                ", passedExams=" + passedExams +
                '}';
    }
}
