package br.com.before.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        String url = "";
        String user = "";
        String pwd = "";

        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
