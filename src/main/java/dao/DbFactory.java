package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbFactory {

    private String userName;

    private String password;

    private String database;

    private String url;

    public DbFactory() {
        this.userName = "root";
        this.password = "root";
        this.database = "EMarket";
        this.url = "jdbc:mysql://localhost:8889/" + this.database;
    }

    public DbFactory(String uName, String psswd, String db, String host, String port) {
        this.userName = uName;
        this.password = psswd;
        this.database = db;
        this.url = "jdbc:mysql://" + host + ":" + port + "/" + db;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return this.database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConnector() {
        try {
            return DriverManager.getConnection(this.url, this.userName, this.password);
        } catch (SQLException e) {
            System.err.println("An error occurred while getting the connector.");
            System.err.println(e.getMessage());

            return null;
        }
    }
}
