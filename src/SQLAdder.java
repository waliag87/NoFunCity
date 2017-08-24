/**
 *
 * A class made to correctly add Event information to an already created SQL Database
 * Created by gwalia on 2017-08-24.
 */
import java.sql.*;
public class SQLAdder {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String databaseLocation = "jdbc:mysql://localhost:3306/NoFunCity?useSSL=false";
    private static String password = "NhL1234"; // TODO: remove this from git when hosted online
    private static String user = "root";

    // Instruction we want to run
    private static String instruction = "insert into events (Name, Date, Description, Location, Time)" + "VALUES(?, ?, ?, ?, ?)";


    /**
     * adds items to database
     * @param name Name of the event
     * @param date Date of the event
     * @param description Description of the event
     * @param location Location of the event
     * @param time Time of the event
     */
    public static void runAdder (String name, String date, String description,
                            String location, String time) throws SQLException {

        try {
            Class.forName(driver);
            }
        catch(ClassNotFoundException e){
            System.out.println("Class not found for driver");
            }
        Connection conn = DriverManager.getConnection(databaseLocation, user, password);
        PreparedStatement preparedStatement = conn.prepareStatement(instruction);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, date);
        preparedStatement.setString(3, description);
        preparedStatement.setString(4, location);
        preparedStatement.setString(5, time);

        preparedStatement.execute();
        conn.close();
    }

}
