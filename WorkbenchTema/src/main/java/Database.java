import java.sql.*;

/**
 * Created by avoica on 11/24/2016.
 */
public class Database {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:mysql://192.168.100.125:3306/drupal";
        String username = "root";
        String password = "root";
        String query = "SELECT * FROM users;";
        String query2 = "SELECT name, mail FROM users WHERE name LIKE '%andra%' AND mail like '%test%' ";
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();
        Statement stmt1 = con.createStatement();


        ResultSet rs = stmt.executeQuery(query);
        ResultSet rs1 = stmt1.executeQuery(query2);


        System.out.println("All database users :");

        while (rs.next()) {
            String myName = rs.getString("name");
            String myMail = rs.getString("mail");
            System.out.println(myName + "-->" + myMail);
        }

        System.out.println("Searching for a specific new entry...");
        while (rs1.next()) {
            String newUser = rs1.getString("name");
            String newMail = rs1.getString("mail");
            System.out.println(newUser + "------->" + newMail);
        }


        con.close();
    }
}
