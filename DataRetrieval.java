import java.sql.*;          //imports all classes, interfaces, etc. from java.sql package

public class DataRetrieval{
    public static void main(String args[]){

        //declare oracle driver name in string object
        String oracleDriver = "oracle.jdbc.driver.OracleDriver";

        // declare oracle rsbase url in string object
        String oracleUrl = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";

        String oracleUser = "system";       // declared the username in string object
        String oraclePass = "toor";         // declared the password in string object

        try{                                //initiated try block for checked exceptions

            //loaded the oracle driver
            Class.forName(oracleDriver);

            // established the connection using rsbase url, user, password
            Connection con = DriverManager.getConnection(oracleUrl,oracleUser,oraclePass);

            System.out.println("Connection established Successfully");

            //declare the SQL query using PreparedStatement
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENTS");

            // query execute and retuns the result into ResultSet object
            ResultSet rs = stmt.executeQuery();
            
            System.out.println("Query executed successfully. Fetching results...");

            while (rs.next()){
                System.out.print(rs.getInt("id")+"\t\t");
                System.out.print(rs.getString("name")+"\t\t");
                System.out.println(rs.getInt("age")+"\t\t");
            }
            
            con.close();    //Connection close

        } catch (Exception e) {             //initiated catch block to identify the exception
            e.printStackTrace();
        }
    }
}