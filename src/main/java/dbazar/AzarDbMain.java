package dbazar;



import java.sql.*;
import java.text.SimpleDateFormat;

public class AzarDbMain {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public static void main(String args[]) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:azardb.db")){
            System.out.println("Opened database successfully");


               MessageInfo.messageInfo(connection);


        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.exit(0);

        }
        System.out.println("Operation done successfully");
    }

}
