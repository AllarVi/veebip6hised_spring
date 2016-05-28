package main.groovy.application.dao;

import main.groovy.application.model.DocType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocTypeRepository extends JpaRepository<DocType, Long> {
}
