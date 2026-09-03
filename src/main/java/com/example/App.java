package com.example;

import java.util.ArrayList;
import java.util.List;

class Subject {
    private String subjectName;
    private int credits;

    public Subject(String subjectName, int credits) {
        this.subjectName = subjectName;
        this.credits = credits;
    }

    public String getSubjectName() { return subjectName; }
    public int getCredits() { return credits; }
}

class Student {
    private String name;
    private String studentId;
    private List<Subject> registeredSubjects;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.registeredSubjects = new ArrayList<>();
    }

    public void registerSubject(Subject subject) {
        registeredSubjects.add(subject);
    }

    public int calculateTotalCredits() {
        int total = 0;
        for (Subject sub : registeredSubjects) {
            total += sub.getCredits();
        }
        return total;
    }

    public boolean isEligible() {
        return calculateTotalCredits() >= 15;
    }

    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public List<Subject> getRegisteredSubjects() { return registeredSubjects; }
}

public class App {
    public static void main(String[] args) {
        
        Student student1 = new Student("Aravind Swamy", "STU202601");
        student1.registerSubject(new Subject("Software Engineering", 4));
        student1.registerSubject(new Subject("Cloud Computing", 4));
        student1.registerSubject(new Subject("DevOps Pipelines", 4));
        student1.registerSubject(new Subject("Agile Methodologies", 4)); // Total 16

        Student student2 = new Student("Meera Nair", "STU202602");
        student2.registerSubject(new Subject("Technical English", 3));
        student2.registerSubject(new Subject("Digital Electronics", 4));
        student2.registerSubject(new Subject("Discrete Mathematics", 4)); // Total 11

        Student[] students = { student1, student2 };

        System.out.println("==================================================");
        System.out.println("         COURSE REGISTRATION SYSTEM REPORT        ");
        System.out.println("==================================================");

        for (Student student : students) {
            System.out.println("\nStudent ID   : " + student.getStudentId());
            System.out.println("Student Name : " + student.getName());
            System.out.println("Selected Subjects:");
            for (Subject sub : student.getRegisteredSubjects()) {
                System.out.println("  - " + sub.getSubjectName() + " (" + sub.getCredits() + " Credits)");
            }
            int totalCredits = student.calculateTotalCredits();
            System.out.println("Total Credits: " + totalCredits);
            System.out.println("Eligibility  : " + (student.isEligible() ? "ELIGIBLE" : "NOT ELIGIBLE (Requires min 15 credits)"));
            System.out.println("--------------------------------------------------");
        }
    }
}
