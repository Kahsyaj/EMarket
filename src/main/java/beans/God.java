package beans;

import schemas.CustomerDbSchema;
import schemas.GodDbSchema;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class God implements Serializable {

    private long id;

    private String pseudo;

    private String password;

    public God() {

    }

    public God(ResultSet result) {
        try {
            this.id = result.getLong(GodDbSchema.ID_COL);
            this.pseudo = result.getString(GodDbSchema.PSEUDO_COL);
            this.password = result.getString(GodDbSchema.PASSWORD_COL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
