package main.groovy.application.dao;


import main.groovy.application.model.DocSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocSubjectRepository extends JpaRepository<DocSubject, Long>{
}
