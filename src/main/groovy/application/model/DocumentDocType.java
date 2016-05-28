package main.groovy.application.model;

import javax.persistence.*;

@Entity
public class DocumentDocType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private DocType docType;

    @ManyToOne
    private Document document;

}
