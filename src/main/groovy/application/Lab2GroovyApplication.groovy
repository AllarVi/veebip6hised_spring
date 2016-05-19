package main.groovy.application

import main.groovy.application.coconut.Coconut
import main.groovy.application.dao.CoconutRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Lab2GroovyApplication extends WebMvcAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(Lab2GroovyApplication.class);

    static void main(String[] args) {
        SpringApplication.run Lab2GroovyApplication, args
    }

    /**
     * We can do our initialization logic and testing here.
     */
    @Bean
    public CommandLineRunner user(CoconutRepository coconutRepository) {
        return new CommandLineRunner() {
            @Override
            void run(String... args) throws Exception {


                Coconut coconut1 = new Coconut();
                coconut1.setId(1);
                coconut1.setName("Young");
                coconut1.setRating(5);
                coconut1.setDescription("Hea film.")
                coconut1.setGenre("Biography")

                coconutRepository.save(coconut1);

                // fetch all coconuts
                log.info("Coconuts found with findAll():");
                log.info("-------------------------------");
                for (Coconut coconut : coconutRepository.findAll()) {
                    log.info(coconut.toString());
                }
                log.info("");
            }
        };
    }
}
