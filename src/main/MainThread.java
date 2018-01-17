package main;

import controller.StudentController;

import model.StudentManager;

import java.util.Scanner;

public class MainThread {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        StudentController studentController = new StudentController();
        StudentManager studentManager = new StudentManager();
        studentController.showmenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    studentManager.addStudent();
                    break;
                case "2":
                    studentController.showListStudent();
                    break;
                case "3":
                    studentController.showStudentByRollNumber();
                    break;
                case "4":
                    studentManager.deleteStudentById();
                    break;
                case "5":
                    studentManager.updateStudentByRollNumber();
                    break;
                case "6":
                    System.err.println("Processing");
                    break;
                case "0":
                    System.err.println("Exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            studentController.showmenu();
        }
    }
}
