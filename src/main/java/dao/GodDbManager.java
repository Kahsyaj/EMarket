package dao;

import beans.God;
import schemas.GodDbSchema;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class GodDbManager extends DbManager {

    public GodDbManager() {
        super();
    }

    public God read(String pseudo, String password) {
        try {
            God god = null;
            String query = String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", GodDbSchema.TABLE,
                    GodDbSchema.PSEUDO_COL, GodDbSchema.PASSWORD_COL);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setString(1, pseudo);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                god = new God(rs);
            }

            rs.close();

            return god;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    public boolean login(String pseudo, String password) {
        try {
            String query = String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", GodDbSchema.TABLE,
                    GodDbSchema.PSEUDO_COL, GodDbSchema.PASSWORD_COL);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setString(1, pseudo);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            boolean success = rs.next();

            rs.close();

            return success;

        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return false;
        }
    }

}
