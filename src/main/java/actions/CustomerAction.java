package actions;

import beans.Customer;
import com.opensymphony.xwork2.ActionSupport;
import dao.CustomerDbManager;

import java.util.List;

public final class CustomerAction extends ActionSupport {

    private long id = -1;

    private Customer customer;

    private List<Customer> customers;

    private String filter;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String doRead() {
        if (this.id == -1) {
            this.addActionError("The customer id must be specified.");
        } else {
            this.customer = new CustomerDbManager().read(this.id);

            if (this.customer == null) {
                this.addActionError("Customer not found with id : " + this.id);
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate() { String result = ActionSupport.INPUT;

        if (this.customer == null) {
            this.addActionError("The customer information must be specified.");
        } else {
            boolean success = new CustomerDbManager().create(this.customer);

            if (!success) {
                this.addActionError("An error occurred with the customer creation.");
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        if (this.customer == null) {
            this.customer = new CustomerDbManager().read(this.id);

            return ActionSupport.INPUT;
        } else {
            boolean success = new CustomerDbManager().update(this.customer);

            if (!success) {
                this.addActionError("An error occurred with the customer update.");
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doDelete() {
        if (this.id == -1) {
            this.addActionError("The customer id must be specified.");
        } else {
            boolean success = new CustomerDbManager().delete(this.id);

            if (!success) {
                this.addActionError("An error occurred with the customer deletion.");
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doList() {
        if (this.filter != null && !this.filter.isEmpty()) {
            this.customers = new CustomerDbManager().queryNameFiltered(this.filter);
        } else {
            this.customers = new CustomerDbManager().queryAll();
        }


        return ActionSupport.SUCCESS;
    }

}
