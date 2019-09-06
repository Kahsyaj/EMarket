package dao;

import beans.Customer;
import schemas.CustomerDbSchema;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class CustomerDbManager extends DbManager {

    public CustomerDbManager() {
        super();
    }

    public boolean create(Customer customer) {
        String statement = String.format("INSERT INTO %s(%s, %s, %s) VALUES(?, ?, ?)", CustomerDbSchema.TABLE,
                CustomerDbSchema.NAME_COL, CustomerDbSchema.EMAIL_COL, CustomerDbSchema.PASSWORD_COL);

        try {
            PreparedStatement preparedStatement = DbManager.getConnector().prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());

            preparedStatement.executeUpdate();

            ResultSet result = preparedStatement.getGeneratedKeys();

            if (result.next()) {
                customer.setId(result.getLong(1));
            }

            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return false;
        }
    }

    public Customer read(long id) {
        try {
            Customer customer = null;
            String query = String.format("SELECT * FROM %s WHERE %s = ?", CustomerDbSchema.TABLE, CustomerDbSchema.ID_COL);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setLong(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                customer = new Customer(rs);
            }

            rs.close();

            return customer;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    public boolean update(Customer customer) {
        try {
            String query = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?", CustomerDbSchema.TABLE,
                    CustomerDbSchema.NAME_COL, CustomerDbSchema.EMAIL_COL, CustomerDbSchema.PASSWORD_COL,
                    CustomerDbSchema.ID_COL);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setString(1, customer.getName());
            st.setString(2, customer.getEmail());
            st.setString(3, customer.getPassword());
            st.setLong(4, customer.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return false;
        }
    }

    public boolean delete(long id) {
        try {
            String query = String.format("DELETE FROM %s WHERE %s = ?", CustomerDbSchema.TABLE, CustomerDbSchema.ID_COL);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setLong(1, id);

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return false;
        }
    }

    public List<Customer> queryAll() {
        try {
            List<Customer> customers = new ArrayList<Customer>();
            String query = String.format("SELECT * FROM %s", CustomerDbSchema.TABLE);

            ResultSet rs = CustomerDbManager.getConnector().createStatement().executeQuery(query);

            while (rs.next()) {
                customers.add(new Customer(rs));
            }

            rs.close();

            return customers;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    public List<Customer> queryNameFiltered(String filter) {
        try {
            List<Customer> customers = new ArrayList<Customer>();
            String query = String.format("SELECT * FROM %s WHERE %s LIKE %s", CustomerDbSchema.TABLE,
                    CustomerDbSchema.NAME_COL, "'%" + filter + "%'");

            ResultSet rs = CustomerDbManager.getConnector().createStatement().executeQuery(query);

            while (rs.next()) {
                customers.add(new Customer(rs));
            }

            rs.close();

            return customers;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

}
