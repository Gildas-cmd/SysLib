package com.database;
import java.sql.*;

public class DatabaseLib {
    private static final String URL = "jdbc:sqlite:bibliotheque.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void init() {
        try (Connection c = getConnection(); Statement s = c.createStatement()) {
            s.execute("CREATE TABLE IF NOT EXISTS livres (id INTEGER PRIMARY KEY AUTOINCREMENT, titre TEXT, auteur TEXT)");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}

