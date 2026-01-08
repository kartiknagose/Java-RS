import java.sql.*;          // JDBC classes
import java.util.*;         // Scanner class

public class ParameterizedQuery2 {

    public static void main(String args[]) {

        System.out.println("Name : Kartik Nagose");
        System.out.println("Batch no. : 2");

        // Oracle JDBC Driver and DB details
        String oracleDriver = "oracle.jdbc.driver.OracleDriver";
        String oracleUrl = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
        String oracleUser = "system";
        String oraclePass = "toor";

        Scanner sc = new Scanner(System.in);

        try {
            // Load Oracle JDBC Driver
            Class.forName(oracleDriver);

            // Establish connection
            Connection con = DriverManager.getConnection(oracleUrl, oracleUser, oraclePass);

            System.out.println("Connection Established Successfully");


            // 1. INSERT Employee details using Scanner    (Parameterized Query)

            System.out.println("\nEnter Employee Details:");

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();   // consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("City: ");
            String city = sc.nextLine();

            System.out.print("Contact: ");
            String contact = sc.nextLine();

            PreparedStatement insertStmt = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?)");

            insertStmt.setInt(1, id);
            insertStmt.setString(2, name);
            insertStmt.setString(3, email);
            insertStmt.setString(4, city);
            insertStmt.setString(5, contact);

            int insert = insertStmt.executeUpdate();
            System.out.println(insert + " employee inserted");


            // 2. UPDATE Employee contact using ID    (Parameterized Query)

            System.out.println("\nUpdate Employee Contact:");

            System.out.print("Enter Employee ID: ");
            int updateId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Contact Number: ");
            String newContact = sc.nextLine();

            PreparedStatement updateStmt = con.prepareStatement("UPDATE employee SET contact = ? WHERE id = ?");

            updateStmt.setString(1, newContact);
            updateStmt.setInt(2, updateId);

            int update = updateStmt.executeUpdate();
            System.out.println(update + " employee updated");


            // 3. SELECT Employees based on City     (Parameterized Query)

            System.out.println("\nDisplay Employees by City:");

            System.out.print("Enter City: ");
            String searchCity = sc.nextLine();

            PreparedStatement selectStmt = con.prepareStatement("SELECT * FROM employee WHERE city = ?");

            selectStmt.setString(1, searchCity);

            ResultSet rs = selectStmt.executeQuery();

            System.out.println("\nEmployee Details:");
            System.out.println("----------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email") + " | " +
                                rs.getString("city") + " | " +
                                rs.getString("contact")
                );
            }

            // Close connection
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
