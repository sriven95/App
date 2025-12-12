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
    private int a, b, c;

    public DBConnection() {
        String url = "jdbc:mysql://localhost:3306/numbers?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "Sriven@123";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connected to 'numbers' database successfully.");

            try (java.sql.Statement stmt = conn.createStatement();
                 java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM input")) {

                if (rs.next()) {
                    a = rs.getInt(2);
                    System.out.println("First number from DB: " + a);
                }
                if (rs.next()) {
                    b = rs.getInt(2);
                    System.out.println("Second number from DB: " + b);
                }
                if (rs.next()) {
                    c = rs.getInt(2);
                    System.out.println("Third number from DB: " + c);
                }

            }
        } catch (java.sql.SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int a() { return a; }
    public int b() { return b; }
    public int c() { return c; }

    public static void main(String[] args) {
        new DBConnection();
    }
}
