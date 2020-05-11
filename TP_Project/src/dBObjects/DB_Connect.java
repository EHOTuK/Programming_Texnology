package dBObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс подлючения к базе данных
 */
public class DB_Connect {

    private final static String url = "jdbc:postgresql://localhost/anatomicalAtlas";
    private final static String user = "postgres";
    private final static String password = "postgres";
    private Connection dbConn = null;

    public DB_Connect() {
        try {
            Class.forName("org.postgresql.Driver");
            dbConn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод возвращает соединение с БД
     *
     * @return соединение
     */
    public Connection getConnection() {
        return dbConn;
    }
}
