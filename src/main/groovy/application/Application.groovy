package main.groovy.application

import main.groovy.application.dao.DocumentRepository
import main.groovy.application.dao.DocTypeRepository
import main.groovy.application.model.Document
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
    public CommandLineRunner user(DocumentRepository documentRepository, DocTypeRepository docTypeRepository) {
        return new CommandLineRunner() {
            @Override
            void run(String... args) throws Exception {

                initDocumentValues()

                initDocTypeValues()

                logDocuments()
            }

            private void logDocuments() {
                log.info("Documents found with findAll():");
                log.info("-------------------------------");
                for (Document document : documentRepository.findAll()) {
                    log.info(document.toString());
                }
                log.info("");
            }

            private void initDocumentValues() {
                Document document1 = new Document();
                document1.setId(1);
                document1.setName("Doc1");
                document1.setDescription("Esimene dokument.");
                document1.setType("Arve");
                document1.setFilename("arve1.pdf");

                Document document2 = new Document();
                document2.setId(2);
                document2.setName("Doc2");
                document2.setDescription("Teine dokument.");
                document2.setType("Tarneleping");
                document2.setFilename("aruanne1.pdf");

                Document document3 = new Document();
                document3.setId(3);
                document3.setName("Doc3");
                document3.setDescription("Kolmas dokument.");
                document3.setType("Tarneleping");
                document3.setFilename("leping1.pdf");

                documentRepository.save(document1);
                documentRepository.save(document2);
                documentRepository.save(document3);
            }

            private void initDocTypeValues() {
                DocType docType1 = new DocType("Arve");
                DocType docType2 = new DocType("Finantsaruanne");
                DocType docType3 = new DocType("Tarneleping");

                docTypeRepository.save(docType1);
                docTypeRepository.save(docType2);
                docTypeRepository.save(docType3);
            }
        };
    }
}
