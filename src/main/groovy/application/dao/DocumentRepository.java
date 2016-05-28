package main.groovy.application.dao;

import main.groovy.application.coconut.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
