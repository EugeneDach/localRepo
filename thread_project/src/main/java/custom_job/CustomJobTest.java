package custom_job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomJobTest {
    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(new Customer(1, "c1", "c1"),
                new Customer(2, "c2", "c2"), new Customer(3, "c3", "c3"));

        List<CustomJob> customJobs = new ArrayList<CustomJob>();
        for (Customer customer : customers) {
            for (int jobId = 0; jobId < 6; jobId++) {
                customJobs.add(new CustomJob(customer, jobId));
            }
        }
        CustomExecutorService customExecutorService = new CustomExecutorService(3);
        for (CustomJob customJob : customJobs) {
            customExecutorService.submit(customJob);
        }

    }
}
