package hugo.ifnmg.bookstore.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handling the connection to the database.
 */
public class DBConnection {
// Properties
    private static Connection connection;
    public static final String URL;
    private static final String USER;
    private static final String PASSWORD;

// Static initialization
    static {
        // Local Server
        URL = "jdbc:mysql://127.0.0.1:3306/bookstore"
                + "?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&serverTimezone=UTC"
                + "&autoReconnect=true";
        USER = "root";
        PASSWORD = "";
    }

//<editor-fold defaultstate="collapsed" desc="Private Constructor">
    private DBConnection() {}
//</editor-fold>

// Methods
    /**
     * Establish and generate the connection to the database.
     *
     * @return Database connection.
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println(">> New connection established to the database.");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                System.out.println(">> Class not found, add driver in libraries.");
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println(ex);
                throw new RuntimeException(ex);
            }
        }
        return connection;
    }
}