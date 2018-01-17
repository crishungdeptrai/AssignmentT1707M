package model;

import java.sql.*;

public class DatabaseConnection {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;


    //get connection
    public void getConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech_fpt?useUnicode=true&characterEncoding=UTF-8", "root", "");
        } catch (SQLException e) {
            System.err.println("Error get connection!");
        }
    }

    //close connection
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error close connection!");
        }
    }

    //create preparedStatement
    public void createPreparedStatement(String sql){
        try {
            this.preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.err.println("Error create preparedStatement!");
        }
    }

    //set string for preparedStatement
    public void preparedStatementSetString(int index, String param){
        try {
            this.preparedStatement.setString(index, param);
        } catch (SQLException e) {
            System.err.println("Error when setString for preparedStatement!");
        }
    }

    //set int for preparedStatement
    public void preparedStatementSetInt(int index, int param){
        try {
            this.preparedStatement.setInt(index, param);
        } catch (SQLException e) {
            System.err.println("Error when setInt for preparedStatement!");
        }
    }

    //set long for preparedStatement
    public void preparedStatementSetLong(int index, long param){
        try {
            this.preparedStatement.setLong(index, param);
        } catch (SQLException e) {
            System.err.println("Error when setLong for preparedStatement!");
        }
    }

    //execute preparedStatement
    public void executePreparedStatement(){
        try {
            this.preparedStatement.executeUpdate();
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println("SUCCESS");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println(this.preparedStatement.toString());
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        } catch (SQLException e) {
            System.err.println("Error execute preparedStatement!");
        }
    }



    //use Resultset get value by executeQuery
    public ResultSet exeQueryPreparedStatement() {
        ResultSet rs = null;
        try {
            rs = this.preparedStatement.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.err.println("Error execute query statement ");
        }
        return rs;
    }



}
