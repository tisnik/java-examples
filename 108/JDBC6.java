/*
 * Java programming language course examples.
 *
 * Copyright (c) 2015  Pavel Tisnovsky, Red Hat
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Red Hat nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Pavel Tisnovsky BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */



import java.sql.*;


public class JDBC6 {
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

    private static void performSelect(Connection connection)
    {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("select * from obsazeni order by postava");
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

    private static void performDelete(Connection conn, int id)
    {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from obsazeni where id = ?;");
            stmt.setInt(1, id);
            boolean result = stmt.execute();
            System.out.println("Delete result: " + result);
        }
        catch (SQLException e) {
            try {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
            closeConnection(conn);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        loadDatabaseDriver();
        Connection connection = null;
        try {
            connection = connectToDatabase();
            System.out.println("Connection information: " + connection.toString());
            performDelete(connection, 10);
            performSelect(connection);
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
