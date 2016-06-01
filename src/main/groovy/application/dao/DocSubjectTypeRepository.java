package main.groovy.application.dao;

import main.groovy.application.model.DocSubjectType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocSubjectTypeRepository extends JpaRepository <DocSubjectType, Long>{
}
