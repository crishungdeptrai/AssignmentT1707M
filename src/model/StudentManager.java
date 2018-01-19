package model;

import controller.StudentController;
import entity.Students;
import string.builder.MyStringBuilder;

import java.sql.ResultSet;
import java.util.*;

public class StudentManager {
    private MyStringBuilder myStringBuilder = new MyStringBuilder();
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private InputInterFace inputInterFace = new InputInterFace();

    // add student to list students
    public void addStudent() {
        String[] attributes = new String[]{"rollNumber", "name", "birthday", "email", "phone", "address", "createdAt", "updatedAt"};

        String insertStringBuilder = myStringBuilder.insertStringBuilder("students", attributes);
        databaseConnection.getConnection();
        databaseConnection.createPreparedStatement(insertStringBuilder);
        databaseConnection.preparedStatementSetString(1, inputInterFace.isValidInputRollNumber());
        databaseConnection.preparedStatementSetString(2, inputInterFace.inputName());
        databaseConnection.preparedStatementSetLong(3, inputInterFace.inputBirthday());
        databaseConnection.preparedStatementSetString(4, inputInterFace.inputEmail());
        databaseConnection.preparedStatementSetString(5, inputInterFace.inputPhone());
        databaseConnection.preparedStatementSetString(6, inputInterFace.inputAddress());
        databaseConnection.preparedStatementSetLong(7, System.currentTimeMillis());
        databaseConnection.preparedStatementSetLong(8, System.currentTimeMillis());
        databaseConnection.executePreparedStatement();
    }

    // get student to list students
    public ArrayList<Students> getListStudent() {
        String getListString = myStringBuilder.selectStringBuilder("students");

        ArrayList<Students> listStudent = new ArrayList<>();

        databaseConnection.getConnection();
        databaseConnection.createPreparedStatement(getListString);
        try {
            ResultSet rs = databaseConnection.exeQueryPreparedStatement();
            while (rs.next()) {
                int id = rs.getInt("id");
                String rollNumber = rs.getString("rollNumber");
                String name = rs.getString("name");
                long birthday = rs.getLong("birthday");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                long createdAt = rs.getLong("createdAt");
                long updatedAt = rs.getLong("updatedAt");
                int status = rs.getInt("status");
                Students student = new Students(id, rollNumber, name, birthday, email, phone, address, createdAt, updatedAt, status);
                listStudent.add(student);
            }
        } catch (Exception e) {
            System.err.println("Error when get student list!");
        }
        return listStudent;
    }

    // get one student by rollNumber
    public Students getStudentByRollNumber() {
        InputInterFace inputInterFace = new InputInterFace();
        boolean exit = false;
        while (true) {
            String rollNumber = inputInterFace.inputRollNumber();
            ArrayList<Students> listStudent = getListStudent();
            Students student = null;
            for (int i = 0; i < listStudent.size(); i++) {
                if (listStudent.get(i).getRollNumber().equals(rollNumber)) {
                    student = listStudent.get(i);
                    break;
                }
            }
            if (student == null) {
                System.err.printf("rollNumber = %s not existed.\n", rollNumber);
            } else {
                return student;
            }
        }
    }

    //get one student by id
    public Students getStudentById() {
        InputInterFace inputInterFace = new InputInterFace();
        boolean exit = false;
        while (true) {
            int id = inputInterFace.inputId();
            ArrayList<Students> listStudent = getListStudent();
            Students student = null;
            for (int i = 0; i < listStudent.size(); i++) {
                if (listStudent.get(i).getId() == id) {
                    student = listStudent.get(i);
                    break;
                }
            }
            if (student == null) {
                System.err.printf("id = %d not existed.\n", id);
            } else {
                return student;
            }
        }
    }

    //update student by id
    public void updateStudentByRollNumber(){
        Students student = getStudentByRollNumber();
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
        Scanner scanner = new Scanner(System.in);
        String yesNo = null;
        boolean exit = false;
        System.out.println("Are you sure you want to update (Y/N)?");
        while (true) {
            yesNo = scanner.nextLine();
            switch (yesNo) {
                case "y":
                case "Y":
                    String[] attributes = new String[]{ "name", "birthday", "email", "phone", "address", "updatedAt"};
                    String update = myStringBuilder.updateStringBuilder("students", attributes, "rollNumber");
                    databaseConnection.getConnection();
                    databaseConnection.createPreparedStatement(update);
                    databaseConnection.preparedStatementSetString(1, inputInterFace.inputName());
                    databaseConnection.preparedStatementSetLong(2, inputInterFace.inputBirthday());
                    databaseConnection.preparedStatementSetString(3, inputInterFace.inputEmail());
                    databaseConnection.preparedStatementSetString(4, inputInterFace.inputPhone());
                    databaseConnection.preparedStatementSetString(5, inputInterFace.inputAddress());
                    databaseConnection.preparedStatementSetLong(6, System.currentTimeMillis());
                    databaseConnection.preparedStatementSetString(7, student.getRollNumber());
                    databaseConnection.executePreparedStatement();
                    System.out.println("Update success student have roll number = " + student.getRollNumber());
                    System.out.println("Do you want update again");
                    break;
                case "n":
                case "N":
                    exit = true;
                    break;
                default:
                    System.err.println("Please only enter Y/y or N/y !");
                    break;
            }
            if (exit) {
                break;
            }
        }
    }

    //delete student by id (Deleted student will move status = 1 )
    public void deleteStudentById() {
        Students student = getStudentById();
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
        Scanner scanner = new Scanner(System.in);
        String yesNo = null;
        boolean exit = false;
        System.out.println("Are you sure you want to delete (Y/N)?");
        while (true) {
            yesNo = scanner.nextLine();
            switch (yesNo) {
                case "y":
                case "Y":
                    String updateStatus = myStringBuilder.updateStatusStringBuilder("students", "status", "id");
                    databaseConnection.getConnection();
                    databaseConnection.createPreparedStatement(updateStatus);
                    databaseConnection.preparedStatementSetInt(1, -1);
                    databaseConnection.preparedStatementSetInt(2, student.getId());
                    databaseConnection.executePreparedStatement();
                    System.out.println("Delete success student have id = " + student.getId());
                case "n":
                case "N":
                    exit = true;
                    break;
                default:
                    System.err.println("Please only enter Y/y or N/y !");
                    break;
            }
            if (exit) {
                break;
            }
        }
    }

}




