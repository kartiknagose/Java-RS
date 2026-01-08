import java.sql.*;              //imports all classes, interfaces, etc. from java.sql package
import java.util.*;             //imports all classes, interfaces, etc. from java.util package

public class DataInsertion{
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
            PreparedStatement stmt = con.prepareStatement("INSERT INTO STUDENTS (id,name,age) VALUES (?,?,?)");


            System.out.print("Enter id : ");         //console input for id
            int id = sc.nextInt();
            stmt.setInt(1,id);          //set the 1st question mark as the value of id


            System.out.print("Enter name : ");       //console input for name
            String name = sc.next();
            stmt.setString(2,name);     //set the 2nd question mark as the value of name


            System.out.print("Enter age : ");        //console input for age
            int age = sc.nextInt();
            stmt.setInt(3,age);         //set the 3rd question mark as the value of age


            int insert = stmt.executeUpdate();       // query execute and retuns the number of affected rows

            System.out.println(insert+" rows inserted");

            sc.close();                              //Scanner closed

            con.close();                             //Connection close

        } catch (Exception e) {                      //initiated catch block to identify the exception

            e.printStackTrace();

        }

    }

}



