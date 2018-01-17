package controller;

import entity.Students;

import model.StudentManager;

import java.util.ArrayList;


public class StudentController {
    StudentManager studentManager = new StudentManager();

    // show student by id
    // return student
    public Students showStudentById() {
        Students student = studentManager.getStudentById();
        System.out.println("Information of student have id = " + student.getId());
        System.out.format("%5s | ", "Id");
        System.out.format("%15s | ", "Roll Number");
        System.out.format("%25s | ", "Name");
        System.out.format("%15s | ", "Birthday");
        System.out.format("%30s | ", "Email");
        System.out.format("%20s | ", "Phone");
        System.out.format("%20s | ", "Address");
        System.out.format("%13s | ", "Created At");
        System.out.format("%13s | ", "Update At");
        System.out.format("%10s%n", "Status");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%5d | ", student.getId());
        System.out.format("%15s | ", student.getRollNumber());
        System.out.format("%25s | ", student.getName());
        System.out.format("%15d | ", student.getBirthday());
        System.out.format("%30s | ", student.getEmail());
        System.out.format("%20s | ", student.getPhone());
        System.out.format("%20s | ", student.getAddress());
        System.out.format("%10d | ", student.getCreatedAt());
        System.out.format("%10d | ", student.getUpdatedAt());
        System.out.format("%10d%n", student.getStatus());
        System.out.println("=======================================================================================================================================================================================================");
        return student;
    }

    // show student by roll number
    // return student
    public Students showStudentByRollNumber() {
        Students student = studentManager.getStudentByRollNumber();
        System.out.println("Information of student have roll number = " + student.getRollNumber());
        System.out.format("%5s | ", "Id");
        System.out.format("%15s | ", "Roll Number");
        System.out.format("%25s | ", "Name");
        System.out.format("%15s | ", "Birthday");
        System.out.format("%30s | ", "Email");
        System.out.format("%20s | ", "Phone");
        System.out.format("%20s | ", "Address");
        System.out.format("%13s | ", "Created At");
        System.out.format("%13s | ", "Update At");
        System.out.format("%10s%n", "Status");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%5d | ", student.getId());
        System.out.format("%15s | ", student.getRollNumber());
        System.out.format("%25s | ", student.getName());
        System.out.format("%15d | ", student.getBirthday());
        System.out.format("%30s | ", student.getEmail());
        System.out.format("%20s | ", student.getPhone());
        System.out.format("%20s | ", student.getAddress());
        System.out.format("%10d | ", student.getCreatedAt());
        System.out.format("%10d | ", student.getUpdatedAt());
        System.out.format("%10d%n", student.getStatus());
        System.out.println("=======================================================================================================================================================================================================");
        return student;
    }

    // show list student
    public void showListStudent() {
        ArrayList<Students> listStudent = studentManager.getListStudent();
        if (listStudent.size() == 0) {
            System.err.println("Empty list students");
        } else {
            System.out.format("%5s | ", "Id");
            System.out.format("%15s | ", "Roll Number");
            System.out.format("%25s | ", "Name");
            System.out.format("%15s | ", "Birthday");
            System.out.format("%30s | ", "Email");
            System.out.format("%20s | ", "Phone");
            System.out.format("%20s | ", "Address");
            System.out.format("%13s | ", "Created At");
            System.out.format("%13s | ", "Update At");
            System.out.format("%10s%n", "Status");
            for (Students student : listStudent) {
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("%5d | ", student.getId());
                System.out.format("%15s | ", student.getRollNumber());
                System.out.format("%25s | ", student.getName());
                System.out.format("%15d | ", student.getBirthday());
                System.out.format("%30s | ", student.getEmail());
                System.out.format("%20s | ", student.getPhone());
                System.out.format("%20s | ", student.getAddress());
                System.out.format("%10d | ", student.getCreatedAt());
                System.out.format("%10d | ", student.getUpdatedAt());
                System.out.format("%10d%n", student.getStatus());
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }


    //create menu

    public void showmenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add student.");
        System.out.println("2. Get list student.");
        System.out.println("3. Get one student by roll number.");
        System.out.println("4. Delete student by id.");
        System.out.println("5. Update student by roll number.");
        System.out.println("6. Sort student by name.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}
