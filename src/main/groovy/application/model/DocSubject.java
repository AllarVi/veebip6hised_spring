package main.groovy.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DocSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String subjectName;

    public DocSubject(String subjectName) {
        this.subjectName = subjectName;
    }

    public DocSubject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


}
