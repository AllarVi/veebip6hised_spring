package main.groovy.application.model;

import javax.persistence.*;

@Entity
public class DocRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private DocSubject docSubject;

    @ManyToOne
    private DocSubjectType docSubjectType;

}
