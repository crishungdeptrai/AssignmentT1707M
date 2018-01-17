package model;

import entity.Students;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InputInterFace {
    public static Scanner scanner = new Scanner(System.in);

    // input id + validate id
    public int isValidInputId() {
        StudentManager studentManager = new StudentManager();
        ArrayList<Students> listStudent = studentManager.getListStudent();
        int id;
        int tempId = 0;
        while (true){
            id = inputId();
            for (int i = 0; i < listStudent.size(); i++){
                if (listStudent.get(i).getId() == id){
                    id = listStudent.get(i).getId();
                    tempId = id;
                    break;
                }
            }
            if (id != tempId){
                System.err.printf("id = %s not existed.\n", id);
            }else {
                return id;
            }
        }
    }
    // input id
    public int inputId() {
        while (true) {
            System.out.println("Enter student id: ");
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.err.println("invalid! Enter student id again: ");
            }
        }
    }

    //input roll number + validate roll number
    public String isValidInputRollNumber() {
        StudentManager studentManager = new StudentManager();
        ArrayList<Students> listStudent = studentManager.getListStudent();
        String tempRollNumber = null;
        String rollNumber;
        while (true) {
            rollNumber = inputRollNumber();
            for (int i = 0; i < listStudent.size(); i++) {
                if (listStudent.get(i).getRollNumber().equals(rollNumber)) {
                    rollNumber = listStudent.get(i).getRollNumber();
                    tempRollNumber = rollNumber;
                    break;
                }
            }
            if (rollNumber.equals(tempRollNumber)) {
                System.err.printf("rollNumber = %s not existed.\n", rollNumber);
            } else {
                    System.out.println("Rollnumber valid!");
                    return rollNumber;
            }
        }
    }


    //input roll number
    public String inputRollNumber() {
        while (true) {
            System.out.println("Enter student roll number: ");
            String rollNumber = scanner.nextLine();
                if (rollNumber.length() == 6){
                    return rollNumber;
                }
                else {
                System.err.println("student'roll number must have 6 characters!");
            }
        }
    }
    // input name + validate name
    public String inputName() {
        String name;
        while (true) {
            System.out.println("Please enter student's name:");
            name = scanner.nextLine();
            if (name.length() < 10) {
                System.err.println("student's name must be greater than 10 characters! ");
            } else {
                System.out.println("Name's student valid!");
                return name;
            }
        }
    }

    //input birthday + validae birtday
    public long inputBirthday() {
        long birhday = 0;
        Date date = null;
        while (date == null) {
            System.out.println("Please enter student's Birthday (MM/DD/YYYY): ");
            String birthday = this.scanner.nextLine();
            try {
                date = new Date(birthday);
                birhday = date.toInstant().toEpochMilli();
            } catch (Exception e) {
                System.err.println("Invalid birthday! Please input with MM/DD/YYYY form!");
            }
        }
        return birhday;

    }

    //input email + validate email
    public String inputEmail() {
        String email;
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        while (true) {
            System.out.println("Please enter student's email:");
            email = scanner.nextLine();
            Boolean isValidEmail = email.matches(emailPattern);
            if (isValidEmail == true) {
                System.out.println("Valid email!");
                return email;
            } else {
                System.err.println("Email inValid!");
            }
        }
    }

    //input phone number + validate
    public String inputPhone() {
        String phone;
        while (true) {
            System.out.println("Please enter student's phone:");
            phone = scanner.nextLine();
            if (phone.length() < 10 || phone.length() > 12) {
                System.err.println("Phone number must be greater than 10 characters! ");
            } else {
                System.out.println("Phone number valid!");
                return phone;
            }
        }

    }

    //input address
    public String inputAddress() {
        System.out.println("Please enter address's student");
        return scanner.nextLine();
    }

    //input status + validate status
    public int inputStatus() {
        while (true) {
            System.out.println("Enter student status: ");
            try {
                int status = Integer.parseInt((scanner.nextLine()));
                return status;
            } catch (NumberFormatException ex) {
                System.err.println("invalid! Enter student status again: ");
            }
        }
    }
}
