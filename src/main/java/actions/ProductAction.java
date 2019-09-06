package actions;

import beans.Product;
import com.opensymphony.xwork2.ActionSupport;
import dao.ProductDbManager;

import java.util.List;

public final class ProductAction extends ActionSupport {

    private long id = -1;

    private Product product;

    private List<Product> products;

    private String filter;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String doRead() {
        if (this.id == -1) {
            this.addActionError("The product id must bne specified.");
        } else {
            this.product = new ProductDbManager().read(this.id);

            if (this.product == null) {
                this.addActionError("Product not found with id : " + this.id + ".");
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate() {
        if (this.product == null) {
            this.addActionError("The product information must be specified.");
        } else {
            boolean success = new ProductDbManager().create(this.product);

            if (!success) {
                this.addActionError("An error occurred with the product creation.");
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        if (this.product == null) {
            this.product = new ProductDbManager().read(this.id);

            return ActionSupport.INPUT;
        } else {
            boolean success = new ProductDbManager().update(this.product);

            if (!success) {
                this.addActionError("An error occurred with the product update.");
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doDelete() {
        if (this.id == -1) {
            this.addActionError("The product id must be specified.");
        } else {
            boolean success = new ProductDbManager().delete(this.id);

            if (!success) {
                this.addActionError("An error occurred with the product deletion.");
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doList() {
        if (this.filter != null && !this.filter.isEmpty()) {
            this.products = new ProductDbManager().queryLabelFiltered(filter);
        } else {
            this.products = new ProductDbManager().queryAll();
        }


        return ActionSupport.SUCCESS;
    }

}
