package beans;

import schemas.ProductDbSchema;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Product implements Serializable {

    private long id;

    private String label;

    private double price;

    public Product() {
    }

    public Product(ResultSet result) {
        try {
            this.id = result.getLong(ProductDbSchema.ID_COL);
            this.label = result.getString(ProductDbSchema.LABEL_COL);
            this.price = result.getDouble(ProductDbSchema.PRICE_COL);
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

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
