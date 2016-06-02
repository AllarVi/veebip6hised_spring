package main.groovy.application.model;

import javax.persistence.*;

@Entity
public class DocSubjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String subjectTypeName;

    public DocSubjectType() {
    }

    public DocSubjectType(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }


}
