package custom_job;

import java.util.concurrent.Callable;

public class CustomJob implements Callable<String> {

    private Customer customer;
    private int id;

    public CustomJob(Customer customer, int id) {
        this.customer = customer;
        this.id = id;
    }

    public String call() throws Exception {
        return String.format("customer %s; job id %s", customer.getId(), id);
    }
}
