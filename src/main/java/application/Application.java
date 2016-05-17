package application;

import application.team.ShortTableRow;
import application.team.ShortTableRowRepository;
import application.team.ShortTeamView;
import application.team.ShortTeamViewRepository;
import application.user.PaceUser;
import application.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring Boot main application.Application
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }

    /**
     * We can do our initialization logic and testing here.
     */
    @Bean
    public CommandLineRunner user(UserRepository userRepository, ShortTableRowRepository shortTableRowRepository,
                                  ShortTeamViewRepository shortTeamViewRepository) {
        return (args) -> {
            PaceUser paceUserAllar = new PaceUser("Allar", "1273703759309879");
            paceUserAllar.setAccessToken
                    ("EAAD08lC2fhMBAIWW7X6j85X0s8IREqlmaXlV47g5NZBOsk22L616ooPDtmUCD7Rup7vVkmKAFP5k5y5zNbf0ZBZB0XGU2fbvaUx7uUxLfY3lStaOyCoo3SiVn9kNGTW5NIon6JC2BNspoLex6NfCBZBkgEZCAyfn0JbICsgpuLu0FTO2zcEsiULORo2nnZBLMZD");

//            Create shortTableRows with mock data and save to database

//            Create map out of shortTableRows

//            @@@@@ Kossurühm @@@@@
            ShortTeamView shortTeamViewKossuryhm = new ShortTeamView();
            shortTeamViewKossuryhm.setTeamName("Kossurühm");

            ArrayList<ShortTableRow> shortTableRowsKossuryhm = getShortTableRowsKossyryhm(shortTableRowRepository);
            List<ShortTableRow> shortTableRowListKossuryhm = new ArrayList<>(shortTableRowsKossuryhm);
            shortTeamViewKossuryhm.setShortTableRowMap(shortTableRowListKossuryhm);

//            @@@@@ Saltopoisid @@@@@
            ShortTeamView shortTeamViewSaltopoisid = new ShortTeamView();
            shortTeamViewSaltopoisid.setTeamName("Saltopoisid");

            ArrayList<ShortTableRow> shortTableRowsSaltopoisid = getShortTableRowsSaltopoisid(shortTableRowRepository);
            List<ShortTableRow> shortTableRowListSaltopoisid = new ArrayList<>(shortTableRowsSaltopoisid);
            shortTeamViewSaltopoisid.setShortTableRowMap(shortTableRowListSaltopoisid);

//            Save shortTeamView to database
            shortTeamViewRepository.save(shortTeamViewKossuryhm);
            shortTeamViewRepository.save(shortTeamViewSaltopoisid);

//            Add shortTeamView to user
            List<ShortTeamView> shortTeamViewList = new ArrayList<>();
//            shortTeamViewList.add(shortTeamViewKossuryhm);
            shortTeamViewList.add(shortTeamViewSaltopoisid);

            paceUserAllar.setShortTeamViewMap(shortTeamViewList);

//            Save user to database
            userRepository.save(paceUserAllar);

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (PaceUser paceUser : userRepository.findAll()) {
                log.info(paceUser.toString());
            }
            log.info("");
        };
    }

    private ArrayList<ShortTableRow> getShortTableRowsKossyryhm(ShortTableRowRepository shortTableRowRepository) {
        ShortTableRow shortTableRow1 = new ShortTableRow(1, "Marin", "Gold", 1270);
        ShortTableRow shortTableRow2 = new ShortTableRow(2, "Marianne", "Gold", 1250);
        ShortTableRow shortTableRow3 = new ShortTableRow(3, "Maarika", "Gold", 1900);

        ArrayList<ShortTableRow> shortTableRows = new ArrayList<>();
        shortTableRows.add(shortTableRow1);
        shortTableRows.add(shortTableRow2);
        shortTableRows.add(shortTableRow3);

        shortTableRows.forEach(shortTableRowRepository::save);

        return shortTableRows;
    }

    private ArrayList<ShortTableRow> getShortTableRowsSaltopoisid(ShortTableRowRepository shortTableRowRepository) {
        ShortTableRow shortTableRow1 = new ShortTableRow(1, "Allar", "Gold", 1000);
        ShortTableRow shortTableRow2 = new ShortTableRow(2, "Rannar", "Gold", 980);
        ShortTableRow shortTableRow3 = new ShortTableRow(3, "Üllar", "Gold", 950);

        ArrayList<ShortTableRow> shortTableRows = new ArrayList<>();
        shortTableRows.add(shortTableRow1);
        shortTableRows.add(shortTableRow2);
        shortTableRows.add(shortTableRow3);

        shortTableRows.forEach(shortTableRowRepository::save);

        return shortTableRows;
    }

    //    Required to enable cross-origin resource sharing
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/*");
                registry.addMapping("/api/*/*");
            }
        };
    }
}
