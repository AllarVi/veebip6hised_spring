package application.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allarviinamae on 15/04/16.
 * <p>
 * Example.
 */
@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/customers", headers = "Accept=application/json")
    List<Customer> customers() {

        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : this.customerRepository.findAll()) {
            customerList.add(customer);
        }

        return customerList;
    }
}
