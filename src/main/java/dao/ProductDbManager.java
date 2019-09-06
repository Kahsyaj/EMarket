package dao;

import beans.Product;
import schemas.ProductDbSchema;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class ProductDbManager extends DbManager {

    public ProductDbManager() {
        super();
    }

    public boolean create(Product product) {
        String statement = String.format("INSERT INTO %s(%s, %s) VALUES(?, ?)", ProductDbSchema.TABLE,
                ProductDbSchema.LABEL_COL, ProductDbSchema.PRICE_COL);

        try {
            PreparedStatement preparedStatement = ProductDbManager.getConnector().prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, product.getLabel());
            preparedStatement.setDouble(2, product.getPrice());

            preparedStatement.executeUpdate();

            ResultSet result = preparedStatement.getGeneratedKeys();

            if (result.next()) {
                product.setId(result.getLong(1));
            }

            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return false;
        }
    }

    public Product read(long id) {
        try {
            Product product = null;
            String query = String.format("SELECT * FROM %s WHERE %s = ?", ProductDbSchema.TABLE, ProductDbSchema.ID_COL);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setLong(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                product = new Product(rs);
            }

            rs.close();

            return product;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    public boolean update(Product product) {
        try {
            String query = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ?", ProductDbSchema.TABLE,
                    ProductDbSchema.LABEL_COL, ProductDbSchema.PRICE_COL, ProductDbSchema.ID_COL);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setString(1, product.getLabel());
            st.setDouble(2, product.getPrice());
            st.setLong(3, product.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return false;
        }
    }

    public boolean delete(long id) {
        try {
            String query = String.format("DELETE FROM %s WHERE %s = ?", ProductDbSchema.TABLE, ProductDbSchema.ID_COL);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setLong(1, id);

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return false;
        }
    }

    public List<Product> queryAll() {
        try {
            List<Product> products = new ArrayList<Product>();
            String query = String.format("SELECT * FROM %s", ProductDbSchema.TABLE);

            ResultSet rs = CustomerDbManager.getConnector().createStatement().executeQuery(query);

            while (rs.next()) {
                products.add(new Product(rs));
            }

            rs.close();

            return products;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    public List<Product> queryLabelFiltered(String filter) {
        try {
            List<Product> products = new ArrayList<Product>();
            String query = String.format("SELECT * FROM %s WHERE %s LIKE %s", ProductDbSchema.TABLE,
                    ProductDbSchema.LABEL_COL, "'%" + filter + "%'");

            ResultSet rs = CustomerDbManager.getConnector().createStatement().executeQuery(query);

            while (rs.next()) {
                products.add(new Product(rs));
            }

            rs.close();

            return products;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

}
