package bank.management.system;

import java.sql.*;

public class Con {
    //connection thru driver manager : need jar file
    Connection connection; //in java.sqlConnection package
    Statement statement;
    public Con(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Tina@2001");
            //give url of database :create in mysql
            statement = connection.createStatement(); //connected the database with our project
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
