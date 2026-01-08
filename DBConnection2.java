import java.sql.Connection;                  //imported Connetion class from java.sql package
import java.sql.DriverManager;               //imported DriverManager class from java.sql package

public class DBConnection2{
    public static void main(String args[]){

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

            con.close();                    //Connection close

        } catch (Exception e) {             //initiated catch block to identify the exception
            e.printStackTrace();
        }
    }
}