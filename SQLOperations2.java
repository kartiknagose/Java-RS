import java.sql.*;              //imports all classes, interfaces, etc. from java.sql package


public class SQLOperations2{
    public static void main(String args[]) throws Exception{

        System.out.println("Name : Kartik Nagose");
        System.out.println("Batch no. : 2");

        //declare oracle driver name in string object
        String oracleDriver = "oracle.jdbc.driver.OracleDriver";

        // declare oracle database url in string object
        String oracleUrl = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";

        String oracleUser = "system";       // declared the username in string object
        String oraclePass = "toor";         // declared the password in string object

        try{                                //initiated try block for checked exceptions

            //loaded the oracle driver
            Class.forName(oracleDriver);

            // established the connection using database url, user, password
            Connection con = DriverManager.getConnection(oracleUrl,oracleUser,oraclePass);

            System.out.println("Connection established Successfully");

            //Table is created using PreparedStatement
            PreparedStatement stmt1 = con.prepareStatement("CREATE TABLE Employee (id int primary key ,name varchar(25), email varchar(25), city varchar(15), contact varchar(10))");

            stmt1.executeUpdate();                    // query executed and Table is created

            System.out.println("Table Created");


            //Inserting data in table using Prepared Statement and SQL Query
            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO Employee VALUES (1, 'Amit Sharma', 'amit.sharma@gmail.com', 'Pune', '9876543210'),(2, 'Neha Verma', 'neha.verma@gmail.com', 'Mumbai', '9123456780')");

            int insert = stmt2.executeUpdate();       // query execute and retuns the number of affected rows

            System.out.println(insert+" rows inserted");


            //Updating data in table using Prepared Statement and SQL Query
            PreparedStatement stmt3 = con.prepareStatement("UPDATE employee SET contact = '8899776655' WHERE id = 2");

            int update = stmt3.executeUpdate();       // query execute and retuns the number of affected rows

            System.out.println(update+" rows updated");


            //Deleting data in table using Prepared Statement and SQL Query
            PreparedStatement stmt4 = con.prepareStatement("DELETE FROM employee WHERE id = 1");

            int delete = stmt4.executeUpdate();       // query execute and retuns the number of affected rows

            System.out.println(delete+" rows deleted");


            con.close();                             //Connection close

        } catch (Exception e) {                      //initiated catch block to identify the exception

            e.printStackTrace();

        }

    }

}



