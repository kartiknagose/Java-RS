import java.sql.*;              //imports all classes, interfaces, etc. from java.sql package
import java.util.*;             //imports all classes, interfaces, etc. from java.util package

public class DataUpdation{
    public static void main(String args[]) throws Exception{

        //created an object of scanner class
        Scanner sc = new Scanner(System.in);

        //declare oracle driver name in string object
        String oracleDriver = "oracle.jdbc.driver.OracleDriver";

        // declare oracle rsbase url in string object
        String oracleUrl = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";

        String oracleUser = "system";       // declared the username in string object
        String oraclePass = "toor";         // declared the password in string object

        try{                                //initiated try block for checked exceptions

            //loaded the oracle driver
            Class.forName(oracleDriver);

            // established the connection using database url, user, password
            Connection con = DriverManager.getConnection(oracleUrl,oracleUser,oraclePass);

            System.out.println("Connection established Successfully");

            //declare the parameterized insert query
            PreparedStatement stmt = con.prepareStatement("UPDATE STUDENTS SET marks = ? WHERE id = ?");


            System.out.print("Enter id : ");           //console input for id
            int id = sc.nextInt();
            stmt.setInt(2,id);            //set the 1st question mark as the value of id


            System.out.print("Enter marks : ");        //console input for marks
            int marks = sc.nextInt();
            stmt.setInt(1,marks);         //set the 2nd question mark as the value of marks


            int insert = stmt.executeUpdate();         // query execute and retuns the number of affected rows

            System.out.println(insert+" rows updated");

            sc.close();                                //Scanner closed

            con.close();                               //Connection close

        } catch (Exception e) {                        //initiated catch block to identify the exception

            e.printStackTrace();

        }

    }

}



