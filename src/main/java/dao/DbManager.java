package dao;

import java.sql.Connection;

public abstract class DbManager {

    private static Connection connector;

    protected static boolean driverLoaded;

    public DbManager() {

        if (!DbManager.driverLoaded) {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                DbManager.driverLoaded = true;
            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }

        DbFactory dbF = new DbFactory();

        if (DbManager.connector == null) {
            DbManager.connector = dbF.getConnector();
        }
    }

    public DbManager(DbFactory dbF) {
        DbManager.connector = dbF.getConnector();
    }

    public static Connection getConnector() {
        return DbManager.connector;
    }

    public static void setConnector(Connection connector) {
        DbManager.connector = connector;
    }

}