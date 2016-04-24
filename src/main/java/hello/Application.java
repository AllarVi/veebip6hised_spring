package hello;

import hello.user.PaceUser;
import hello.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));
            repository.save(new Customer("Allar", "Viinamäe"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findOne(2L);
            log.info("Customer found with findOne(2L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (Customer bauer : repository.findByLastName("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }

    @Bean
    public CommandLineRunner user(UserRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new PaceUser("Allar", "123451234512345"));

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (PaceUser paceUser : repository.findAll()) {
                log.info(paceUser.toString());
            }
            log.info("");

            // fetch users by facebookId
            log.info("PaceUser found with findByFacebookId('123451234512345'):");
            log.info("--------------------------------------------");
            for (PaceUser paceUser : repository.findByFacebookId("123451234512345")) {
                log.info(paceUser.toString());
            }
            log.info("");
        };
    }

}
