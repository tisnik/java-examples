import java.sql.*;


public class JDBC1 {
    private static void loadDatabaseDriver() throws InstantiationException, ClassNotFoundException, IllegalAccessException
    {
        Class.forName("org.sqlite.JDBC").newInstance();
    }

    private static Connection connectToDatabase() throws SQLException
    {
        return DriverManager.getConnection("jdbc:sqlite:../db/test.db");
    }

    private static void closeConnection(Connection conn)
    {
        try {
            if (conn != null)
                conn.close();
        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        loadDatabaseDriver();
        Connection connection = null;
        try {
            connection = connectToDatabase();
            System.out.println("Connection information: " + connection.toString());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
            System.out.println("Connection closed: " + connection.toString());
        }
    }

}
