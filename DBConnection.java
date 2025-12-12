/*
 Sample JDBC connection to MySQL database named `numbers`.

 Instructions:
 1. Download the MySQL Connector/J (mysql-connector-j-8.x.x.jar).
 2. Place the JAR in this folder (C:\Work\app) or a known path.
 3. Compile:
    Windows PowerShell:
    javac -cp .;mysql-connector-j-8.0.33.jar DBConnection.java

    (replace the jar name with the actual downloaded filename)

 4. Run:
    java -cp .;mysql-connector-j-8.0.33.jar DBConnection

 5. Edit `url`, `user`, and `pass` below to match your MySQL server.
*/
public class DBConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/numbers?useSSL=false&serverTimezone=UTC";
        String user = "root"; // change to your DB user
        String pass = "Sriven@123"; // change to your DB password

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connected to 'numbers' database successfully.");
            try (java.sql.Statement stmt = conn.createStatement();
                 java.sql.ResultSet rs = stmt.executeQuery("SELECT 1")) {
                if (rs.next()) {
                    System.out.println("Test query returned: " + rs.getInt(1));
                }
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
