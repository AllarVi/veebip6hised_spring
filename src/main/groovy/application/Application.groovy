package main.groovy.application

import main.groovy.application.dao.CoconutRepository
import main.groovy.application.dao.DocTypeRepository
import main.groovy.application.model.Coconut
import main.groovy.application.model.DocType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application extends WebMvcAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    /**
     * We can do our initialization logic and testing here.
     */
    @Bean
    public CommandLineRunner user(CoconutRepository coconutRepository, DocTypeRepository docTypeRepository) {
        return new CommandLineRunner() {
            @Override
            void run(String... args) throws Exception {

                initCoconutValues()

                initDocTypeValues()

                logCoconuts()
            }

            private void logCoconuts() {
                log.info("Coconuts found with findAll():");
                log.info("-------------------------------");
                for (Coconut coconut : coconutRepository.findAll()) {
                    log.info(coconut.toString());
                }
                log.info("");
            }

            private void initCoconutValues() {
                Coconut coconut1 = new Coconut();
                coconut1.setId(1);
                coconut1.setName("Young");
                coconut1.setRating(5);
                coconut1.setDescription("Noor kookos, väga tervislik.")
                coconut1.setWeight(2500)

                Coconut coconut2 = new Coconut();
                coconut2.setId(2);
                coconut2.setName("Old");
                coconut2.setRating(1);
                coconut2.setDescription("Vana kookos, pigem mitte süüa.")
                coconut2.setWeight(2500)

                Coconut coconut3 = new Coconut();
                coconut3.setId(3);
                coconut3.setName("Raw");
                coconut3.setRating(2);
                coconut3.setDescription("Toores kookos. Söö, kui julged.")
                coconut3.setWeight(2500)

                coconutRepository.save(coconut1);
                coconutRepository.save(coconut2);
                coconutRepository.save(coconut3);
            }

            private void initDocTypeValues() {
                DocType docType1 = new DocType("arve");
                DocType docType2 = new DocType("finantsaruanne");
                DocType docType3 = new DocType("tarneleping");

                docTypeRepository.save(docType1);
                docTypeRepository.save(docType2);
                docTypeRepository.save(docType3);
            }
        };
    }
}
