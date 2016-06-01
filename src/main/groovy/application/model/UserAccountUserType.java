package main.groovy.application.model;

import javax.persistence.*;

@Entity
public class UserAccountUserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private UserType userType;

    @ManyToOne
    private UserAccount userAccount;

}
