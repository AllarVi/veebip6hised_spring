package main.groovy.application.dao

import main.groovy.application.model.Coconut
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoconutRepository extends JpaRepository<Coconut, Integer> {
}