package beans;

import schemas.CustomerDbSchema;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Customer implements Serializable {

    private long id;

    private String name;

    private String email;

    private String password;

    public Customer() {
    }

    public Customer(ResultSet result) {
        try {
            this.id = result.getLong(CustomerDbSchema.ID_COL);
            this.name = result.getString(CustomerDbSchema.NAME_COL);
            this.email = result.getString(CustomerDbSchema.EMAIL_COL);
            this.password = result.getString(CustomerDbSchema.PASSWORD_COL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
