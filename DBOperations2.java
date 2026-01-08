import java.sql.*;      // JDBC classes
import java.util.*;     // Scanner class

public class DBOperations2 {
    public static void main(String args[]) {

        System.out.println("Name : Kartik Nagose");
        System.out.println("Batch no. : 2");

        String oracleDriver = "oracle.jdbc.driver.OracleDriver";
        String oracleUrl = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
        String oracleUser = "system";
        String oraclePass = "toor";

        Scanner sc = new Scanner(System.in);

        try {
            // Load Oracle Driver
            Class.forName(oracleDriver);

            // Establish connection
            Connection con = DriverManager.getConnection(oracleUrl, oracleUser, oraclePass);
            System.out.println("Connection established successfully");

            // a. Create Product Table
            PreparedStatement stmt1 = con.prepareStatement("CREATE TABLE Product (id INT PRIMARY KEY,name VARCHAR(30),price DOUBLE PRECISION,quantity INT)");
            //stmt1.executeUpdate();
            System.out.println("Product table created");

            // b. Insert Product Details
            System.out.println("\nEnter Product Details:");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?)");
            stmt2.setInt(1, id);
            stmt2.setString(2, name);
            stmt2.setDouble(3, price);
            stmt2.setInt(4, quantity);

            int insert = stmt2.executeUpdate();
            System.out.println(insert + " product inserted");

            // c. Update Quantity
            System.out.print("\nEnter Product ID to update quantity: ");
            int updateId = sc.nextInt();

            System.out.print("Enter New Quantity: ");
            int newQty = sc.nextInt();

            PreparedStatement stmt3 = con.prepareStatement("UPDATE Product SET quantity = ? WHERE id = ?");
            stmt3.setInt(1, newQty);
            stmt3.setInt(2, updateId);

            int update = stmt3.executeUpdate();
            System.out.println(update + " product updated");

            // d. Delete Product
            System.out.print("\nEnter Product ID to delete: ");
            int deleteId = sc.nextInt();

            PreparedStatement stmt4 = con.prepareStatement("DELETE FROM Product WHERE id = ?");
            stmt4.setInt(1, deleteId);

            int delete = stmt4.executeUpdate();
            System.out.println(delete + " product deleted");

            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
