package main.groovy.application

import main.groovy.application.dao.DocSubjectRepository
import main.groovy.application.dao.DocSubjectTypeRepository
import main.groovy.application.dao.DocumentRepository
import main.groovy.application.dao.DocTypeRepository
import main.groovy.application.dao.UserAccountRepository
import main.groovy.application.dao.UserTypeRepository
import main.groovy.application.model.DocSubject
import main.groovy.application.model.DocSubjectType
import main.groovy.application.model.Document
import main.groovy.application.model.DocType
import main.groovy.application.model.UserAccount
import main.groovy.application.model.UserType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
class Application extends WebMvcAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(Application.class);



    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    /**
     * We can do our initialization logic and testing here.
     */
    @Bean
    public CommandLineRunner user(DocumentRepository documentRepository, DocTypeRepository docTypeRepository,
                                  DocSubjectRepository docSubjectRepository, DocSubjectTypeRepository docSubjectTypeRepository,
                                  UserAccountRepository userAccountRepository, UserTypeRepository userTypeRepository) {
        return new CommandLineRunner() {
            @Override
            void run(String... args) throws Exception {

                initDocumentValues()

                initDocTypeValues()

                initDocSubjectValues()

                initDocSubjectTypeValues()

                initUserAccountValues()

                initUserTypeValues()

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

            private void initDocSubjectTypeValues() {
                DocSubjectType docSubjectType1 = new DocSubjectType("Autor");
                DocSubjectType docSubjectType2 = new DocSubjectType("Tema kohta");
                DocSubjectType docSubjectType3 = new DocSubjectType("Talle saadetud");
                DocSubjectType docSubjectType4 = new DocSubjectType("Saatja");

                docTypeRepository.save(docSubjectType1);
                docTypeRepository.save(docSubjectType2);
                docTypeRepository.save(docSubjectType3);
                docTypeRepository.save(docSubjectType4);

            }

            private void initDocSubjectValues() {
                DocSubject docSubject1 = new DocSubject("Marten Maasikas");
                DocSubject docSubject2 = new DocSubject("Anna Aru");
                DocSubject docSubject3 = new DocSubject("Tanel Tuisk");
                DocSubject docSubject4 = new DocSubject("Jüri Juurikas");
                DocSubject docSubject5 = new DocSubject("Maali Maalt");

                docTypeRepository.save(docSubject1);
                docTypeRepository.save(docSubject2);
                docTypeRepository.save(docSubject3);
                docTypeRepository.save(docSubject4);
                docTypeRepository.save(docSubject5);

            }

            private void initUserAccountValues(){
                UserAccount user1 = new UserAccount();
                user1.setUsername("qwerty");
                user1.setPassword(encoder.encode("1234"));
                user1.setType("tootaja");

                UserAccount user2 = new UserAccount();
                user2.setUsername("asdfg");
                user2.setPassword(encoder.encode("1234"));
                user2.setType("klient");

                userAccountRepository.save(user1);
                userAccountRepository.save(user2);
            }

            private void initUserTypeValues(){
                UserType userType1 = new UserType("tootaja");
                UserType userType2 = new UserType("klient");

                userTypeRepository.save(userType1);
                userTypeRepository.save(userType2);

            }
        };
    }
}
