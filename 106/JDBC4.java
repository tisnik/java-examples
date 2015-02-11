import java.sql.*;


public class JDBC4 {
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

    private static void performSelect(Connection connection, String postava)
    {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("select * from obsazeni where postava = ?");
            stmt.setString(1, postava);
            ResultSet results = stmt.executeQuery();
            System.out.println("Table contents:");
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("postava");
                String surname = results.getString("jmeno");
                System.out.format("%2d\t%-10s\t%-10s\n", id, name, surname);
            }
        }
        catch (SQLException e) {
            try {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        loadDatabaseDriver();
        Connection connection = null;
        try {
            connection = connectToDatabase();
            System.out.println("Connection information: " + connection.toString());
            performSelect(connection, "tovarnik");
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
